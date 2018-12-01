package com.slow.shell.repository;

import com.slow.shell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/1 21:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
	@Autowired
	private ProductInfoRepository repository;
	@Test
	public void findByProductStatus() {
		List<ProductInfo> productInfoList = repository.findByProductStatus(0);
		Assert.assertNotEquals(0,productInfoList.size());
	}
	@Test
	public void saveTest(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("12");
		productInfo.setProductName("皮蛋粥");
		productInfo.setProductPrice(new BigDecimal(5.0));
		productInfo.setProductStock(100);
		productInfo.setProductDescription("好喝的粥");
		productInfo.setProductIcon("http//XXX.jpg");
		productInfo.setProductStatus(0);
		productInfo.setCategoryType(3);
		ProductInfo result = repository.save(productInfo);
		Assert.assertNotNull(result);
	}
}