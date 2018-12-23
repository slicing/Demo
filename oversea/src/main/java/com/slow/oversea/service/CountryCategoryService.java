package com.slow.oversea.service;

import com.slow.oversea.dataobject.CountryCategory;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/18 8:26
 */
public interface CountryCategoryService {
	CountryCategory findOne(Integer id);
	List<CountryCategory> findAll();
	CountryCategory findByName(String name);
	void save(CountryCategory countryCategory);
	void delete(CountryCategory countryCategory);
}
