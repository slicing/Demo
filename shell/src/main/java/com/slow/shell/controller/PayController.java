package com.slow.shell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.service.OrderService;
import com.slow.shell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/5 22:39
 */
@Controller
@RequestMapping("/pay")
public class PayController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private PayService payService;
	@GetMapping("/create")
	public ModelAndView create(@RequestParam("orderId") String orderId,
							   @RequestParam("returnUrl") String returnUrl,
							   Map<String,Object> map){
		//1.查询订单
		OrderDto orderDto = orderService.findOne(orderId);
		if(orderDto == null){
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		//2.发起支付
		PayResponse payResponse = payService.create(orderDto);
		map.put("payResponse","111111111");
		return new ModelAndView("pay/create",map);
	}
	//异步通知
	@PostMapping("/notify")
	public ModelAndView notify(@RequestParam String notifyData){
		payService.notify(notifyData);
		return new ModelAndView("/pay/success");
	}
}
