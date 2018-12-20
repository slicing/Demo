package com.slow.oversea.repository;

import com.slow.oversea.dataobject.UniversityCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/18 14:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversityCategoryRepositoryTest {
	@Autowired
	private UniversityCategoryRepository repository;

	@Test
	public void save(){
		UniversityCategory category = new UniversityCategory();
		category.setUniversityId(1);
		category.setUniversityName("北京大学");
		category.setCountryId(1);
		repository.save(category);
	}

	@Test
	public void findCountryIdByUniversityId() {

	}

	@Test
	public void findUniversityNameByUniversityId() {
	}

	@Test
	public void findByUniversityName() {
	}
}