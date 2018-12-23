package com.slow.oversea.controller;

import com.slow.oversea.dataobject.UniversityCategory;
import com.slow.oversea.service.UniversityCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/22 0:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversityControllerTest {

	@Autowired
	private UniversityCategoryService service;
	@Test
	public void getList() {
		List<UniversityCategory> categoryList = service.findUniversityByCountryId(1);
		for (UniversityCategory university : categoryList ){
			System.out.println(university);
		}
	}
}