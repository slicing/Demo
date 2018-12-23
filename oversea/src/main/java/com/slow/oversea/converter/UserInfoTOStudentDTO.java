package com.slow.oversea.converter;

import com.slow.oversea.dataobject.UserInfo;
import com.slow.oversea.dto.StudentDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Slicing
 * @date 2018/12/20 8:27
 */
public class UserInfoTOStudentDTO {
	public static StudentDTO convert(UserInfo userInfo){
		StudentDTO studentDTO = new StudentDTO();
		BeanUtils.copyProperties(userInfo,studentDTO);
		return studentDTO;
	}
	public static List<StudentDTO> convert(List<UserInfo> userInfoList){
		return  userInfoList.stream().map(e -> convert(e)).collect(Collectors.toList());
	}
}
