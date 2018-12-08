package com.slow.shell.repository;

import com.slow.shell.dataobject.SellerInfo;
import com.slow.shell.util.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/8 20:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
	@Autowired
	private SellerInfoRepository sellerInfoRepository;
	@Test
	public void save(){
		SellerInfo sellerInfo = new SellerInfo();
		sellerInfo.setSellerId(KeyUtil.genUnitqueKey());
		sellerInfo.setUsername("slow");
		sellerInfo.setPassword("admin");
		sellerInfo.setOpenid("abc");
		sellerInfoRepository.save(sellerInfo);

	}

	@Test
	public void findByOpenid() {
		SellerInfo result = sellerInfoRepository.findByOpenid("abc");
		Assert.assertNotNull(result);

	}
}