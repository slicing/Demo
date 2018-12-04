package com.slow.shell.repository;

import com.slow.shell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/3 16:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRespositoryTest {
	@Autowired
	private OrderDetailRespository orderDetailRespository;
	@Test
	public void saveTest(){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("1235");
		orderDetail.setOrderId("111112");
		orderDetail.setProductIcon("http://xxx.jpg");
		orderDetail.setProductId("121214");
		orderDetail.setProductName("皮蛋粥");
		orderDetail.setProductPrice(new BigDecimal(5.0));
		orderDetail.setProductQuantity(3);
		OrderDetail result = orderDetailRespository.save(orderDetail);
		Assert.assertNotEquals(0,result);
	}

	@Test
	public void findByOrderId() {
		List<OrderDetail> orderDetailList = orderDetailRespository.findByOrderId("111112");
		Assert.assertNotEquals(0,orderDetailList.size());

	}
}