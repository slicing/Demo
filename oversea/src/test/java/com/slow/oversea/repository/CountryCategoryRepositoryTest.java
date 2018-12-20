package com.slow.oversea.repository;

import com.slow.oversea.dataobject.CountryCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author Slicing
 * @date 2018/12/17 21:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryCategoryRepositoryTest {

	@Autowired
	private CountryCategoryRepository repository;
	@Test
	public void save(){
		CountryCategory countryCategory = new CountryCategory();
		countryCategory.setCountryId(1);
		countryCategory.setCountryName("中国");
		repository.save(countryCategory);
	}
}