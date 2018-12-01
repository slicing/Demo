package com.slow.shell.repository;

import com.slow.shell.dataobject.ProductCategory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Slicing
 * @date 2018/12/1 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	@Test
	public void fingOneTest(){
		ProductCategory productCatergory = productCategoryRepository.findById(1).get();
		System.out.println(productCatergory.toString());
	}
	@Test
	public void saveTest(){
		ProductCategory productCategory = productCategoryRepository.getOne(2);
		productCategory.setCategoryType(10);

		/*ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(2);
		productCategory.setCategoryName("猪最爱");
		productCategory.setCategoryType(3);*/
		productCategoryRepository.save(productCategory);
	}
}