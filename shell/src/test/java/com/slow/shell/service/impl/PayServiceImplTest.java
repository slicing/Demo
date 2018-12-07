package com.slow.shell.service.impl;

import com.slow.shell.dto.OrderDto;
import com.slow.shell.service.OrderService;
import com.slow.shell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Slicing
 * @date 2018/12/6 10:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
	@Autowired
	private PayService payService;
	@Autowired
	private OrderService orderService;


	@Test
	public void create() {
		OrderDto orderDto = orderService.findOne("");
		payService.create(orderDto);
	}


	@Test
	public void refund(){
		OrderDto orderDto = orderService.findOne("");
		payService.refund(orderDto);
	}
}