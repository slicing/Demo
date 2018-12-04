package com.slow.shell.service.impl;

import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.service.BuyerService;
import com.slow.shell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Slicing
 * @date 2018/12/4 20:41
 */
@Service
public class BuyerOrderService implements BuyerService {
	@Autowired
	private OrderService orderService;
	@Override
	public OrderDto findOrderOne(String openid, String orderId) {
		return checkOrderOwner(openid, orderId);
	}

	@Override
	public OrderDto cancelOrder(String openid, String orderId) {
		OrderDto orderDto = checkOrderOwner(openid,orderId);
		if (orderDto == null)
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		return orderService.cancel(orderDto);
	}
	private OrderDto checkOrderOwner(String openid, String orderId){
		OrderDto orderDto = orderService.findOne(orderId);
		if (orderDto == null)
			return null;
		if (!orderDto.getBuyerOpenid().equals(openid))
			throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
		return orderDto;
	}
}
