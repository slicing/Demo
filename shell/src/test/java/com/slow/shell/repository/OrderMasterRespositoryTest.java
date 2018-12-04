package com.slow.shell.repository;

import com.slow.shell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/2 22:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRespositoryTest {
	@Autowired
	private OrderMasterRespository orderMasterRespository;
	private final String OPENID = "2121";
	@Test
	public void saveTest(){
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("122");
		orderMaster.setBuyerName("猪猪");
		orderMaster.setBuyerPhone("123456789");
		orderMaster.setBuyerAddress("我的心里");
		orderMaster.setBuyerOpenid("OPENID");
		orderMaster.setOrderAmount(new BigDecimal(5.22));
		OrderMaster result = orderMasterRespository.save(orderMaster);
		Assert.assertNotNull(result);
	}
	@Test
	public void findByBuyerOpenid() {
		PageRequest request = PageRequest.of(0,1);
		Page<OrderMaster> result =  orderMasterRespository.findByBuyerOpenid(OPENID,request);
		Assert.assertNotEquals(0,result);
	}
}