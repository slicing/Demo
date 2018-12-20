package com.slow.oversea.repository;

import com.slow.oversea.dataobject.CountryCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/17 21:23
 */
public interface CountryCategoryRepository extends JpaRepository<CountryCategory,Integer> {
	CountryCategory findByCountryName(String name);
}
