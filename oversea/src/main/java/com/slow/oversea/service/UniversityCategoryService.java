package com.slow.oversea.service;

import com.slow.oversea.dataobject.UniversityCategory;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/18 8:12
 */
public interface UniversityCategoryService {
	UniversityCategory findOne(Integer id);
	List<UniversityCategory> findAll();
	UniversityCategory findByName(String name);
	Integer findCountryId(Integer universityId);
	String findUniversityName(Integer universityId);
	List<UniversityCategory> findUniversityByCountryId(Integer countryId);
	void save(UniversityCategory universityCategory);
	void delete(UniversityCategory universityCategory);
}
