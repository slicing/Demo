package com.slow.shell.controller;

import com.slow.shell.config.ProjectUrlConfig;
import com.slow.shell.constant.CookieConstant;
import com.slow.shell.constant.RedisConstant;
import com.slow.shell.dataobject.SellerInfo;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.service.SellerService;
import com.slow.shell.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.cs.ext.MacArabic;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 卖家用户
 * @author Slicing
 * @date 2018/12/9 16:35
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

	@Autowired
	private SellerService sellerService;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private ProjectUrlConfig projectUrlConfig;
	@GetMapping("/login")
	public ModelAndView login(@RequestParam("openid") String openid,
							  HttpServletResponse response,
							  Map<String,Object> map){

		//1.openid去和数据库里的数据破匹配
		SellerInfo sellerInfo  = sellerService.findSellerInfoByOpenid(openid);
		if (sellerInfo == null){
			map.put("msg",ResultEnum.LOGIN_FAIL.getMessage());
			map.put("url","/sell/seller/order/list");
			return new ModelAndView("common/error");
		}
		//2.设置token至redis;
		String token = UUID.randomUUID().toString();
		Integer expire = RedisConstant.EXPIRE;
		redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire,TimeUnit.SECONDS);
		//3.设置token至cookie

		CookieUtil.set(response,CookieConstant.TOKEN,token,expire);
		return new ModelAndView("redirect:" +projectUrlConfig.getSell() +  "/sell/seller/order.list");
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,
					   HttpServletResponse response,
					   Map<String,Object> map){
		//1.从cookie查询
		Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
		if (cookie != null){
			//2.清除redis
			redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX));
			//3.清除cookie
			CookieUtil.set(response,CookieConstant.TOKEN,null,0);
		}
		map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
		map.put("url","/sell/seller/order/list");
		return new ModelAndView("common/success",map);

	}

}
