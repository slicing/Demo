package com.slow.shell.repository;

import com.slow.shell.dataobject.ProductCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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
	@Transactional//测试通过，但数据不会留在数据库（回滚）
	public void saveTest(){
		ProductCategory productCategory = new ProductCategory("男生最爱",4);
		ProductCategory result = productCategoryRepository.save(productCategory);
		Assert.assertNotNull(result);
		//Assert.assertNotEquals(null,result);
	}
	@Test
	public void findByCategoryTypeInTest(){
		List<Integer> list = Arrays.asList(2,3);
		List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
		Assert.assertNotEquals(0,result.size());
	}
}