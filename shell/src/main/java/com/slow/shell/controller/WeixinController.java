package com.slow.shell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Slicing
 * @date 2018/12/5 10:59
 */
@RestController
@RequestMapping("/weixin")
public class WeixinController {
	@GetMapping("/auth")
	public void auth(@RequestParam("code") String code){

	}
}
