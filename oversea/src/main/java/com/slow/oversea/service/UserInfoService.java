package com.slow.oversea.service;

import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.StudentDTO;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 22:50
 */
public interface UserInfoService {
	UserInfo findOne(Integer userId);
	UserInfo findByName(String userName);
	List<StudentDTO> findAll();
	UserInfo save(UserInfo userInfo);
	UserInfo getLocalAuthByUserNameAndUserPass(String userName, String passWord);
}
