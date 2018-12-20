package com.slow.oversea.controller;

import com.slow.oversea.dataobject.UniversityCategory;
import com.slow.oversea.service.UniversityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/18 15:47
 */
@RestController
@RequestMapping("/oversea/university")
public class UniversityController {
	@Autowired
	private UniversityCategoryService categoryService;

	@GetMapping("/list")
	public List<UniversityCategory> getAll(){
		List<UniversityCategory> result = categoryService.findAll();
		return result;
	}
}
