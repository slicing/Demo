package com.slow.oversea.controller;

import com.slow.oversea.dataobject.CountryCategory;
import com.slow.oversea.service.CountryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/19 17:12
 */
@Controller
@RequestMapping("country/category")
public class CountryCategoryController {
	@Autowired
	private CountryCategoryService categoryService;

	/**
	 * 国家列表
	 * @param map
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView list(Map<String,Object> map){
		List<CountryCategory> countryCategoryList = categoryService.findAll();
		map.put("countryCategoryList",countryCategoryList);
		return new ModelAndView("country/list",map);
	}

	/**
	 * 查询
	 * @param countryId
	 * @param map
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer countryId,
							  Map<String,Object> map) {
		if (countryId != null){
			CountryCategory countryCategory = categoryService.findOne(countryId);
			map.put("countryCategory",countryCategory);
		}
		return new ModelAndView("country/index",map);
	}


}
