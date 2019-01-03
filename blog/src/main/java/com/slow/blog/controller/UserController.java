package com.slow.blog.controller;

import com.slow.blog.dataobject.User;
import com.slow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Slicing
 * @date 2019/1/3 18:36
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView list(Model model){
		List<User> attributeValue = userService.listUser();
		model.addAttribute("userList",attributeValue);
		model.addAttribute("title","用户管理");
		return new ModelAndView("users/list","userModel",model);
	}

	@GetMapping("{id}")
	public ModelAndView getById(@PathVariable long id, Model model){
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		return new ModelAndView("users/view","userModel",model);
	}

	@RequestMapping("/save")
	public ModelAndView save(User user,Model model){
		userService.save(user);
		return new ModelAndView("/users/form","userModel",model);
	}
}
