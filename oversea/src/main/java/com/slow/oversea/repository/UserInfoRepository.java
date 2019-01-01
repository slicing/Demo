package com.slow.oversea.repository;

import com.slow.oversea.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


/**
 * @author Slicing
 * @date 2018/12/17 18:00
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
	UserInfo findByUserName(String userInfoName);
	UserInfo findByUserNameAndUserPass(String userName,String userPass);
	UserInfo queryLocalByUserNameAndUserPass(@Param("userName") String username, @Param("userPass") String password);

}
