package com.slow.oversea.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Slicing
 * @date 2018/12/17 22:30
 */
@Data
@Entity
@Table(name = "university_category")
public class UniversityCategory {
	@Id
	private Integer universityId;

	private String universityName;

	private Integer countryId;


	public UniversityCategory() {
	}

	public UniversityCategory(Integer universityId, String universityName, Integer countryId) {
		this.universityId = universityId;
		this.universityName = universityName;
		this.countryId = countryId;
	}
}
