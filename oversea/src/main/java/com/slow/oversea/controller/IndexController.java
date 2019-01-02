package com.slow.oversea.controller;

import com.slow.oversea.dataobject.CountryCategory;
import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.service.CountryCategoryService;
import com.slow.oversea.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Slicing
 * @date 2019/1/1 15:05
 */
@Controller
@RequestMapping("/front")
public class IndexController {
	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private CountryCategoryService categoryService;

	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("student/login");
	}
	@RequestMapping("/addregister")
	public ModelAndView register(HttpServletRequest request,Map<String,Object> map){
		String username = request.getParameter("username");
		Integer userAge = Integer.parseInt(request.getParameter("userAge"));
		Integer userGender = Integer.parseInt(request.getParameter("userGender"));
		Integer userCountry = categoryService.findByName(request.getParameter("userCountry")).getCountryId();
		String userAddress = request.getParameter("userAddress");
		String userTele = request.getParameter("userTele");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (password.equals(password2)){
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(username);
			userInfo.setUserPass(password);
			userInfo.setAge(userAge);
			userInfo.setGender(userGender);
			userInfo.setUserNationalityId(userCountry);
			userInfo.setUserAddress(userAddress);
			userInfo.setUserTele(userTele);
			userInfoService.save(userInfo);
			map.put("userInfoService",userInfoService);
			map.put("url","student/login");
			return new ModelAndView("common/success",map);
		}
		return new ModelAndView("student/login",map);

	}

}
