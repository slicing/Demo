package com.slow.oversea.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Slicing
 * @date 2018/12/17 21:49
 */
@Data
@Entity
@Table(name = "admin_info")
public class AdminInfo {
	@Id
	private Integer adminId;

	private String adminName;

	private Integer age;

	private Integer adminCountry;

	private Integer adminUniver;

	public AdminInfo() {
	}

	public AdminInfo(Integer adminId, String adminName, Integer age, Integer adminCountry, Integer adminUniver) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.age = age;
		this.adminCountry = adminCountry;
		this.adminUniver = adminUniver;
	}


}
