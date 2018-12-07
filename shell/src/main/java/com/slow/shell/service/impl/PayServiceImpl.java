package com.slow.shell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.service.OrderService;
import com.slow.shell.service.PayService;
import com.slow.shell.util.JsonUtil;
import com.slow.shell.util.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Slicing
 * @date 2018/12/5 22:46
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {
	private final static  String ORDER_NAME = "微信点餐订单";
	@Autowired
	private BestPayServiceImpl bestPayService;
	@Autowired
	private OrderService orderService;

	@Override
	public PayResponse create(OrderDto orderDto) {
		PayRequest payRequest = new PayRequest();
		payRequest.setOpenid(orderDto.getBuyerOpenid());
		payRequest.setOrderAmount(orderDto.getOrderAmount().doubleValue());
		payRequest.setOrderId(orderDto.getOrderId());
		payRequest.setOrderName(ORDER_NAME);
		payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
		log.info("【微信支付】发起支付 request={}" ,JsonUtil.toJson(payRequest));
		PayResponse payResponse = bestPayService.pay(payRequest);
		log.info("【微信支付】 发起支付 response={}",JsonUtil.toJson(payRequest));
		return payResponse;
	}

	@Override
	public PayResponse notify(String notifyData) {
		//1.验证签名
		//2.支付状态
		//3.支付金额
		//4.支付人（下单人 == 支付人）

		PayResponse payResponse = bestPayService.asyncNotify(notifyData);
		log.info("【微信支付】 异步通知，payResponse={}",payResponse);

		//查询订单
		OrderDto orderDto = orderService.findOne(payResponse.getOrderId());
		//判断订单是否存在
		if (orderDto == null){
			log.error("【微信支付】 异步通知，订单不存在，orderId={}",payResponse.getOrderId());
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		//判断金额是否一致
		if (!MathUtil.equals(payResponse.getOrderAmount(),orderDto.getOrderAmount().doubleValue())){
			log.error("【微信支付】 异步通知，订单金额不一致，orderId={},微信通知金额={},系统金额={}",payResponse.getOrderId(),
					payResponse.getOrderAmount(),
					orderDto.getOrderAmount());
			throw new SellException(ResultEnum.WXPAY_NOTITY_MONEY_VERIFY_ERROR);
		}
		//修改订单支付状态

		orderService.paid(orderDto);
		return payResponse;
	}

	@Override
	public RefundResponse refund(OrderDto orderDto) {
		RefundRequest refundRequest = new RefundRequest();
		refundRequest.setOrderId(orderDto.getOrderId());
		refundRequest.setOrderAmount(orderDto.getOrderAmount().doubleValue());
		refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
		log.info("【微信退款】 request={}",JsonUtil.toJson(refundRequest));
		RefundResponse refundResponse = bestPayService.refund(refundRequest);
		log.info("【微信退款】 response={}",JsonUtil.toJson(refundResponse));
		return refundResponse;
	}
}
