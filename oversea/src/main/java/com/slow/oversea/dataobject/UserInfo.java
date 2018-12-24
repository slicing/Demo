package com.slow.oversea.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Slicing
 * @date 2018/12/17 14:11
 */
@Entity
@Data
@Table(name = "user_info")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	/*用户名*/
	private String userName;
	/*密码*/
	private String userPass;
	/*用户年龄*/
	private Integer age;
	/*用户性别*/
	private Integer gender;
	/*用户国籍*/
	private Integer userNationalityId;
	/*用户地址*/
	@JsonIgnore
	private String userAddress;
	/*用户电话*/
	@JsonIgnore
	private String userTele;

	public UserInfo(String userName, Integer age, String userPass, Integer gender, Integer userNationalityId, String userAddress, String userTele) {
		this.userName = userName;
		this.age = age;
		this.userPass = userPass;
		this.gender = gender;
		this.userNationalityId = userNationalityId;
		this.userAddress = userAddress;
		this.userTele = userTele;
	}

	public UserInfo() {
	}
}
