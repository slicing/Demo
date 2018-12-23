package com.slow.oversea.service.impl;

import com.slow.oversea.dataobject.CountryCategory;
import com.slow.oversea.repository.CountryCategoryRepository;
import com.slow.oversea.service.CountryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/18 8:27
 */
@Service
public class CountryCategoryServiceImpl implements CountryCategoryService {
	@Autowired
	private CountryCategoryRepository repository;

	@Override
	public CountryCategory findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public List<CountryCategory> findAll() {
		return repository.findAll();
	}

	@Override
	public CountryCategory findByName(String name) {
		return repository.findByCountryName(name);
	}

	@Override
	public void save(CountryCategory countryCategory) {
		repository.save(countryCategory);
	}

	@Override
	public void delete(CountryCategory countryCategory) {
		repository.delete(countryCategory);
	}
}
