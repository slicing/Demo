package com.slow.oversea.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Slicing
 * @date 2018/12/20 8:23
 */
@Data
public class StudentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	/*用户名*/
	private String userName;
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

}
