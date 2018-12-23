package com.slow.oversea.service.impl;

import com.slow.oversea.dataobject.UniversityCategory;
import com.slow.oversea.repository.UniversityCategoryRepository;
import com.slow.oversea.service.UniversityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/18 8:14
 */
@Service
public class UniversityCategoryServiceImpl implements UniversityCategoryService {
	@Autowired
	private UniversityCategoryRepository repository;
	@Override
	public UniversityCategory findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public List<UniversityCategory> findAll() {
		return repository.findAll();
	}

	@Override
	public UniversityCategory findByName(String name) {
		return repository.findByUniversityName(name);
	}

	@Override
	public Integer findCountryId(Integer universityId) {
		return repository.findCountryIdByUniversityId(universityId);
	}

	@Override
	public String findUniversityName(Integer universityId) {
		return repository.findUniversityNameByUniversityId(universityId);
	}

	@Override
	public List<UniversityCategory> findUniversityByCountryId(Integer countryId) {
		return repository.findUniversityByCountryId(countryId);
	}

	@Override
	public void save(UniversityCategory universityCategory) {
		repository.save(universityCategory);
	}

	@Override
	public void delete(UniversityCategory universityCategory) {
		repository.delete(universityCategory);
	}
}
