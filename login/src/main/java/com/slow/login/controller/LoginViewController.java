package com.slow.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginViewController {
	private String rightName = "admin";
	private String rightPass = "admin";

	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (null == username || null == password)
			return "redirect:/";
		String info = rightName.toLowerCase() + rightPass.toLowerCase();
		String realPassword = DigestUtils.md5DigestAsHex(info.getBytes());
		if (!password.equals(realPassword))
			return "redirect:/";
		request.getSession().setAttribute("loginName","admin");
		return "redirect:/welcome";
	}


	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/";
	}
}
