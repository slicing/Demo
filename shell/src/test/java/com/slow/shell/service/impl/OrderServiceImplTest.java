package com.slow.shell.service.impl;

import com.slow.shell.dataobject.OrderDetail;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.OrderStatusEnum;
import com.slow.shell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/3 18:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
	@Autowired
	private OrderServiceImpl orderService;

	private final String BUYER_OPENID = "2121";
	private final String ORDER_ID = "1543883896314130437";
	@Test
	public void create() {
		OrderDto orderDto = new OrderDto();
		orderDto.setBuyerName("猪猪");
		orderDto.setBuyerAddress("你的心里");
		orderDto.setBuyerPhone("12323124134");
		orderDto.setBuyerOpenid(BUYER_OPENID);
		List<OrderDetail> orderDetailList = new ArrayList<>();
		OrderDetail o1 = new OrderDetail();
		o1.setProductId("13");
		o1.setProductQuantity(2);
		orderDetailList.add(o1);
		OrderDetail o2 = new OrderDetail();
		o2.setProductId("12");
		o2.setProductQuantity(2);
		orderDetailList.add(o2);
		orderDto.setOrderDetailList(orderDetailList);

		OrderDto result = orderService.create(orderDto);
		Assert.assertNotNull(result);
	}

	@Test
	public void findOne() {
		OrderDto result = orderService.findOne(ORDER_ID);
		Assert.assertNotNull(result);
	}

	@Test
	public void findList() {
		PageRequest result = PageRequest.of(0,2);
		Page<OrderDto> orderDtoPage =  orderService.findList(BUYER_OPENID,result);
		Assert.assertNotEquals(0,orderDtoPage.getTotalElements());
	}
	@Test
	public void list(){
		PageRequest request = PageRequest.of(0,2);
		Page<OrderDto> orderDtoPage = orderService.findList(request);
		//Assert.assertNotEquals(0,orderDtoPage.getTotalElements());
		Assert.assertTrue("查询所有订单",orderDtoPage.getTotalElements()>0);
	}

	@Test
	public void cancel() {
		OrderDto orderDto = orderService.findOne(ORDER_ID);
		OrderDto result = orderService.cancel(orderDto);
		Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
	}

	@Test
	public void finish() {
		OrderDto orderDto = orderService.findOne(ORDER_ID);
		OrderDto result = orderService.finish(orderDto);
		Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
	}

	@Test
	public void paid() {
		OrderDto orderDto = orderService.findOne(ORDER_ID);
		OrderDto result = orderService.paid(orderDto);
		Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
	}
}