package com.slow.shell.controller;

import com.slow.shell.dto.OrderDto;
import com.slow.shell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端
 * @author Slicing
 * @date 2018/12/5 12:02
 */
@Controller
@RequestMapping("/seller/order")
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
		PageRequest request = PageRequest.of(page,size);
		Page<OrderDto> orderDtoPage = orderService.findList(request);
		map.put("orderDtoPage",orderDtoPage);
		return new ModelAndView("order/list",map);
	}
}
