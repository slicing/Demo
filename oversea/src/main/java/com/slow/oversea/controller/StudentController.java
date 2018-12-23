package com.slow.oversea.controller;


import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.StudentDTO;
import com.slow.oversea.service.UserInfoService;
import com.slow.oversea.utils.CodeUtils;
import com.slow.oversea.utils.HttpServletRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@GetMapping("/list")
	public ModelAndView list(Map<String,Object> map){
		List<StudentDTO> studentDTOList = userInfoService.findAll();
		map.put("studentDTOList",studentDTOList);
		return new ModelAndView("common/list",map);
	}
	//登录验证
	@ResponseBody
	@RequestMapping(value = "/loginCheck", method = POST)
	public Map<String, Object> loginCheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		boolean needVerify = HttpServletRequestUtils.getBollean(request, "needVerify");

		if (needVerify && !CodeUtils.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}

		String username = HttpServletRequestUtils.getString(request, "username");
		String password = HttpServletRequestUtils.getString(request, "password");

		if (username != null && password != null) {
			UserInfo userInfo = userInfoService.getLocalAuthByUserNameAndUserPass(username, password);
			if (userInfo != null) {
				modelMap.put("success", true);
				//登录成功设置session
				/**
				 * setSession
				 */
				request.getSession().setAttribute("user",userInfo.getUserName());
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");

		}
		return modelMap;
	}


	/**
	 * 注册账号
	 *
	 * @param request
	 * @return
	 */

	/*@ResponseBody
	@RequestMapping(value = "/registeraccount", method = POST)
	public Map<String, Object> register(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		//验证码
		if (!CodeUtils.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		ObjectMapper mapper = new ObjectMapper();
		UserInfo userInfo = null;
		//判断账号信息
		String localAuthStr = HttpServletRequestUtils.getString(request, "localAuthStr");
		try {
			//接收前端传来的相关的字符串信息,将它转换成实体类
			userInfo = mapper.readValue(localAuthStr, UserInfo.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}




		try {
			if (userInfo!= null && userInfo.getUserName() != null && !userInfo.getUserName().equals("") && userInfo.getUserPass() != null && !userInfo.getUserPass().equals("")) {
				LocalAuthExecution le = localAuthService.register(localAuth, thumbnail);
				if (le.getState() == LocalAuthEnum.SUCCESS.getState()) {
					//注册成功设置session
					*//**
					 * setSession
					 *//*
					request.getSession().setAttribute("user", le.getLocalAuth().getPersonInfo());
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", le.getStateInfo());
					return modelMap;
				}
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "信息输入缺失");
				return modelMap;
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		return modelMap;
	}*/

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
