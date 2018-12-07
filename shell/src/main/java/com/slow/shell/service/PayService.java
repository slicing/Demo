package com.slow.shell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.slow.shell.dto.OrderDto;

/**
 * 支付
 * @author Slicing
 * @date 2018/12/5 22:43
 */
public interface PayService {
	PayResponse create(OrderDto orderDto);
	PayResponse notify(String notifyData);
	RefundResponse refund(OrderDto orderDto);
}
