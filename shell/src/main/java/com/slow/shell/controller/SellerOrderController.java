package com.slow.shell.controller;

import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.util.Map;

/**
 * 卖家端
 * @author Slicing
 * @date 2018/12/5 12:02
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {
	@Autowired
	private OrderService orderService;
	/**
	 * 订单列表
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
							 @RequestParam(value = "size",defaultValue = "10") Integer size,
							 Map<String,Object> map){
		PageRequest request = PageRequest.of(page-1,size);
		Page<OrderDto> orderDtoPage = orderService.findList(request);
		map.put("orderDtoPage",orderDtoPage);
		map.put("currentPage",page);
		map.put("size",size);
		return new ModelAndView("order/list",map);
	}

	/**
	 * 取消订单
	 * @param orderId
	 * @return
	 */

	@GetMapping("/cancel")
	public ModelAndView cancel(@RequestParam("orderId") String orderId,
							   Map<String,Object> map){
		try {
			OrderDto orderDto = orderService.findOne(orderId);

			orderService.cancel(orderDto);
		}catch (SellException e){
			log.error("【卖家端取消订单】 发生异常 {}",e);
			map.put("msg",e.getMessage());
			map.put("url","sell/seller/order/list");
			return new ModelAndView("common/error",map);
		}
		map.put("msg",ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
		map.put("url","sell/seller/order/list");
		return new ModelAndView("common/success",map);
	}


	/**
	 * 订单详情
	 * @param orderId
	 * @param map
	 * @return
	 */
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("orderId") String orderId,
							   Map<String,Object> map){
		OrderDto orderDto = new OrderDto();
		try {
			orderDto = orderService.findOne(orderId);
		}catch (SellException e){
			log.error("【卖家端查看详情】 发生异常 {}",e);
			map.put("msg",e.getMessage());
			map.put("url","sell/seller/order/list");
			return new ModelAndView("common/error",map);
		}
		map.put("orderDto",orderDto);
		return new ModelAndView("order/detail",map);
	}


	/**
	 *完结订单
	 * @param orderId
	 * @param map
	 * @return
	 */
	@GetMapping("/finish")
	public ModelAndView finished(@RequestParam("orderId") String orderId,
								 Map<String,Object> map){
		try {
			OrderDto orderDto = orderService.findOne(orderId);
			orderService.finish(orderDto);
		}catch (SellException e){
			log.error("【卖家端完结订单】 发生异常 {}",e);
			map.put("msg",e.getMessage());
			map.put("url","sell/seller/order/list");
			return new ModelAndView("common/error",map);
		}
		map.put("msg",ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
		map.put("url","sell/seller/order/list");
		return new ModelAndView("common/success",map);

	}
}
