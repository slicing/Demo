package com.slow.oversea.controller;


import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.StudentDTO;
import com.slow.oversea.service.UserInfoService;
import com.slow.oversea.utils.CodeUtils;
import com.slow.oversea.utils.HttpServletRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
		return new ModelAndView("student/login",map);
	}

	/**
	 * 学生列表
	 * @param map
	 * @return
	 */
	@Transactional
	@GetMapping("/list")
	public ModelAndView list(Map<String,Object> map){
		List<StudentDTO> studentDTOList = userInfoService.findAll();
		map.put("studentDTOList",studentDTOList);
		return new ModelAndView("common/list",map);
	}


	/**
	 * 登出
	 *
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = POST)
	public Map<String, Object> logout(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		/**
		 * setSession
		 */
		request.getSession().invalidate();
		modelMap.put("success", true);
		return modelMap;
	}
}
