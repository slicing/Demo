package com.slow.conversion.controller;

import com.slow.conversion.model.ConsumerExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginViewController {
	ConsumerExcel consumerExcel = new ConsumerExcel();
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (null == username || null == password)
			return "redirect:/";
		String realPassword = String.valueOf(consumerExcel.getData().get(username));
		if (!password.equals(realPassword))
			return "redirect:/";
		request.getSession().setAttribute("loginName",username);
		return "redirect:/welcome";
	}
	/*
	* 注销登录
	* @param request
	* @return
	* */
	@RequestMapping("loginout")
	public String loginOut(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/";
	}
}
