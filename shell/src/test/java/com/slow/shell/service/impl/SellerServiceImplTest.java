package com.slow.shell.service.impl;

import com.slow.shell.dataobject.SellerInfo;
import com.slow.shell.repository.SellerInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/8 21:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

	private final static String openid = "abc";
	@Autowired
	private SellerServiceImpl sellerService;

	@Test
	public void findSellerInfoByOpenid() {
		SellerInfo result = sellerService.findSellerInfoByOpenid(openid);
		Assert.assertNotNull(openid,result.getOpenid());
	}
}