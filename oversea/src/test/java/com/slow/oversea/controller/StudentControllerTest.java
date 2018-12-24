package com.slow.oversea.controller;

import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.StudentDTO;
import com.slow.oversea.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Slicing
 * @date 2018/12/22 1:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

	@Autowired
	private UserInfoService userInfoService;
	@Test
	public void list() {
		List<StudentDTO> studentDTOList = userInfoService.findAll();
		for(StudentDTO studentDTO:studentDTOList){
			System.out.println(studentDTO);
		}
	}
	@Transactional
	@Test
	public void findOne(){
		UserInfo userInfo = userInfoService.findOne(1);
		System.out.println(userInfo);
	}
}