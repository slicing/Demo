package com.slow.oversea.controller;

import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.CartDTO;
import com.slow.oversea.service.ApplicationService;
import com.slow.oversea.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author Slicing
 * @date 2019/1/2 21:14
 */
@Controller
@RequestMapping("/front")
public class LoginController {
	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/addlogin")
	public ModelAndView appLogin(@RequestParam String username, @RequestParam String password,Map<String,Object> map){
		UserInfo userInfo  = userInfoService.findByName(username);
		if (userInfo == null) {
			map.put("msg","账户不存在");
			map.put("url","/student/login");
			return new ModelAndView("common/error",map);
		} else {
			if (userInfo.getUserPass().equals(password)) {
				map.put("msg","登陆成功");
				map.put("url","/application/get/list");
				return new ModelAndView("common/success",map);
			} else {
				map.put("msg","密码错误");
				map.put("url","/student/login");
				return new ModelAndView("common/error",map);
			}
		}

	}
}
