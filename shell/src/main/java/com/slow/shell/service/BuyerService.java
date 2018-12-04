package com.slow.shell.service;

import com.slow.shell.dto.OrderDto;

/**
 * 买家
 * @author Slicing
 * @date 2018/12/4 20:39
 */
public interface BuyerService {
	//查询一个订单
	OrderDto findOrderOne(String openid,String orderId);
	//取消订单
	OrderDto cancelOrder(String openid,String orderId);
}
