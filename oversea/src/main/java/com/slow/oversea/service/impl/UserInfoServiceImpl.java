package com.slow.oversea.service.impl;

import com.slow.oversea.converter.UserInfoTOStudentDTO;
import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.StudentDTO;
import com.slow.oversea.repository.UserInfoRepository;
import com.slow.oversea.service.UserInfoService;
import com.slow.oversea.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 22:52
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserInfo findOne(Integer userId) {
		return repository.getOne(userId);
	}

	@Override
	public UserInfo findByName(String userName) {
		return repository.findByUserName(userName);
	}

	@Override
	public List<StudentDTO> findAll() {
		List<UserInfo> userInfoList = repository.findAll();
		List<StudentDTO> studentDTOList = UserInfoTOStudentDTO.convert(userInfoList);
		return studentDTOList;
	}

	@Override
	public UserInfo save(UserInfo userInfo) {
		return repository.save(userInfo);
	}

	@Override
	public UserInfo getLocalAuthByUserNameAndUserPass(String userName, String passWord) {
		return repository.queryLocalByUserNameAndUserPass(userName, MD5.getMd5(passWord));
	}
}
