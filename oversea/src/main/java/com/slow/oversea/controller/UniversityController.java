package com.slow.oversea.controller;

import com.slow.oversea.dataobject.UniversityCategory;
import com.slow.oversea.enums.ResultEnum;
import com.slow.oversea.exception.OverSeaException;
import com.slow.oversea.form.CountryCategoryForm;
import com.slow.oversea.service.UniversityCategoryService;
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
 * @date 2018/12/18 15:47
 */
@Controller
@RequestMapping("/oversea/university")
public class UniversityController {
	@Autowired
	private UniversityCategoryService categoryService;

	/**
	 *列表
	 * @param map
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView getAll(Map<String,Object> map){
		List<UniversityCategory> universityCategoryList = categoryService.findAll();
		map.put("universityCategoryList",universityCategoryList);
		return new ModelAndView("university/list",map);
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
			UniversityCategory universityCategory = categoryService.findOne(countryId);
			categoryService.delete(universityCategory);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/oversea/university/list");
			return new ModelAndView("common/error");
		}
		map.put("msg",ResultEnum.COUNTRY_CATEGORY_DELETE_SUCCESS);
		map.put("url","/oversea/university/list");
		return new ModelAndView("common/success",map);

	}

	/**
	 * 国家学校列表
	 * @param countryId
	 * @param map
	 * @return
	 */
	@GetMapping("/country/list")
	public ModelAndView getList(@RequestParam(value = "countryId") Integer countryId,
								Map<String,Object> map){
		List<UniversityCategory> universityCategoryList = categoryService.findUniversityByCountryId(countryId);
		map.put("universityCategoryList",universityCategoryList);
		return new ModelAndView("country/university",map);
	}

	/**
	 * 客户端
	 * 国家学校列表
	 * @param countryId
	 * @param map
	 * @return
	 */
	@GetMapping("/student/country/list")
	public ModelAndView getStudentList(@RequestParam(value = "countryId") Integer countryId,
								Map<String,Object> map){
		List<UniversityCategory> universityCategoryList = categoryService.findUniversityByCountryId(countryId);
		map.put("universityCategoryList",universityCategoryList);
		return new ModelAndView("student/university",map);
	}
	/**
	 * 查询
	 * @param countryId
	 * @param map
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView index(@RequestParam(value = "countryId") Integer countryId,
							  Map<String,Object> map) {
		if (countryId != null){
			UniversityCategory universityCategory = categoryService.findOne(countryId);
			map.put("universityCategory",universityCategory);
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
			map.put("url","/oversea/university/index");
			return new ModelAndView("common/error",map);
		}
		UniversityCategory universityCategory = new UniversityCategory();
		try {
			if (form.getCategoryId() != null){
				universityCategory = categoryService.findOne(form.getCategoryId());
			}
			BeanUtils.copyProperties(form,universityCategory);
			categoryService.save(universityCategory);
		}catch (OverSeaException e){
			map.put("msg",e.getMessage());
			map.put("url","/oversea/university/index");
			return new ModelAndView("common/error",map);
		}
		map.put("url","/oversea/university/index");
		return new ModelAndView("common/success",map);

	}

}
