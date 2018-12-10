package com.slow.shell.service;

import com.slow.shell.dto.OrderDto;

/**
 * 推送消息
 * @author Slicing
 * @date 2018/12/10 20:03
 */
public interface PushMessageService {

	/**
	 * 订单状态变更消息
	 * @param orderDto
	 */
	void orderStatus(OrderDto orderDto);
}
