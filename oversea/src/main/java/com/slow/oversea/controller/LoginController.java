package com.slow.oversea.controller;

import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Slicing
 * @date 2019/1/2 21:14
 */
@RestController
@RequestMapping("/app")
public class LoginController {
	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/login")
	public int appLogin(@RequestParam String username,@RequestParam String password){
		UserInfo userInfo  = userInfoService.findByName(username);
		if (userInfo.getUserPass().equals(password))
			return 1;
		else
			return 0;
	}
}
