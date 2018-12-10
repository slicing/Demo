package com.slow.shell.service.impl;

import com.slow.shell.dto.OrderDto;
import com.slow.shell.service.OrderService;
import com.slow.shell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author Slicing
 * @date 2018/12/10 20:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {
	@Autowired
	private PushMessageService pushMessageService;

	@Autowired
	private OrderService orderService;
	@Test
	public void orderStatus() {
		OrderDto orderDto = orderService.findOne("");
		pushMessageService.orderStatus(orderDto);
	}
}