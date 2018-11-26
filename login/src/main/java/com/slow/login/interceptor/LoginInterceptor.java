package com.slow.login.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 在请求被处理之前调用
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
		Object loginName = request.getSession().getAttribute("loginName");
		if (null == loginName || !(loginName instanceof String)){
			response.sendRedirect("/");
			return false;
		}
		String username = (String)loginName;
		System.out.println("当前用户已登录，用户名为：" + username);
		return true;
	}
	/**
	 *在请求被处理后，视图渲染之前调用
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){

	}

}
