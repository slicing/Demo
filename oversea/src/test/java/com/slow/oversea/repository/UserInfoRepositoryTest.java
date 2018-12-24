//package com.slow.oversea.repository;
//
//import com.slow.oversea.dataobject.UserInfo;
//import com.slow.oversea.enums.GenderEnum;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
///**
// * @author Slicing
// * @date 2018/12/17 18:09
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserInfoRepositoryTest {
//	@Autowired
//	private UserInfoRepository respository;
//	@Test
//	public void save(){
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUserName("slow");
//		userInfo.setAge(16);
//		userInfo.setGender(GenderEnum.FEMALE.getCode());
//		userInfo.setUserAddress("陕西省西安市");
//		//userInfo.setUserNationalityId();
//	}
//
//
//}