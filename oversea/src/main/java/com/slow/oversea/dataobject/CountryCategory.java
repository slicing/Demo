package com.slow.oversea.dataobject;

import jdk.nashorn.internal.ir.IdentNode;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Slicing
 * @date 2018/12/17 18:34
 */
@Entity
@Data
@Table(name = "country_category")
public class CountryCategory {
	@Id
	private Integer countryId;

	private String countryName;

	public CountryCategory() {
	}

	public CountryCategory(Integer countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
	}
}
