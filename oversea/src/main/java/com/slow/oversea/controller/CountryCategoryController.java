package com.slow.oversea.controller;

import com.slow.oversea.dataobject.ApplicationTable;
import com.slow.oversea.dataobject.CountryCategory;
import com.slow.oversea.enums.ResultEnum;
import com.slow.oversea.exception.OverSeaException;
import com.slow.oversea.form.CountryCategoryForm;
import com.slow.oversea.service.CountryCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
	 * 用户端国家列表
	 * @param map
	 * @return
	 */
	@GetMapping("/student/list")
	public ModelAndView studentList(Map<String,Object> map){
		List<CountryCategory> countryCategoryList = categoryService.findAll();
		map.put("countryCategoryList",countryCategoryList);
		return new ModelAndView("student/list",map);
	}

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
	 * 删除
	 * @param countryId
	 * @param map
	 * @return
	 */
	@PutMapping("/delete")
	public ModelAndView delete(@RequestParam(value = "categoryId",required = false) Integer countryId,
							   Map<String,Object> map){
		try {
			CountryCategory countryCategory = categoryService.findOne(countryId);
			categoryService.delete(countryCategory);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","country/category/list");
			return new ModelAndView("/common/error");
		}
		map.put("msg",ResultEnum.COUNTRY_CATEGORY_DELETE_SUCCESS);
		map.put("url","country/category/list");
		return new ModelAndView("common/success",map);

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

	/**
	 *
	 * @param form
	 * @param bindingResult
	 * @param map
	 * @return
	 */
	@PostMapping("/save")
	public ModelAndView save(@Valid CountryCategoryForm form,
							 BindingResult bindingResult,
							 Map<String,Object> map){
		if (bindingResult.hasErrors()){
			map.put("msg",bindingResult.getFieldError().getDefaultMessage());
			map.put("url","/country/category/index");
			return new ModelAndView("common/error",map);
		}
		CountryCategory countryCategory = new CountryCategory();
		try {
			if (form.getCategoryId() != null){
				countryCategory = categoryService.findOne(form.getCategoryId());
			}
			BeanUtils.copyProperties(form,countryCategory);
			categoryService.save(countryCategory);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/country/category/index");
			return new ModelAndView("common/error",map);
		}
		map.put("url","/country/category/index");
		return new ModelAndView("common/success",map);

	}


}
