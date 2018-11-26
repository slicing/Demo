package com.slow.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexViewController {
	@GetMapping("/")
	public String index(){
		return "login";
	}
	@GetMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
}
