package com.slow.conversion.controller;

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
	@GetMapping("/conversion")
	public String conversion(){
		return "conversion";
	}

}
