package com.slow.shell.aspect;

import com.slow.shell.constant.CookieConstant;
import com.slow.shell.constant.RedisConstant;
import com.slow.shell.exception.SellerAuthorizeException;
import com.slow.shell.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Slicing
 * @date 2018/12/9 17:53
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Pointcut("execution(public * com.slow.shell.controller.Seller*.*(..))" + "&& !execution(public * com.slow.shell.controller.SellerUserController.*(..))		")
	public void verify() {
	}

	@Before("verify()")
	public void doVerify(){
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//查询cookie
		Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
		if (cookie == null){
			log.warn("【登录校验】cookie查不到token");
			throw new SellerAuthorizeException();
		}
		//去redis查
		String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
		if (StringUtils.isEmpty(tokenValue)){
			log.warn("【登录校验】redis查不到token");
			throw new SellerAuthorizeException();
		}

	}

}
