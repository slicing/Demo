package com.slow.oversea.controller;

import com.slow.oversea.dto.StudentDTO;
import com.slow.oversea.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/20 8:07
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/login")
	public ModelAndView login(Map<String,Object> map){
		return new ModelAndView("",map);
	}

	/**
	 * 学生列表
	 * @param map
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView list(Map<String,Object> map){
		List<StudentDTO> studentDTOList = userInfoService.findAll();
		map.put("studentDTOList",studentDTOList);
		return new ModelAndView("/student/list",map);
	}
}
