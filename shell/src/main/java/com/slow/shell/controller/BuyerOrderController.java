package com.slow.shell.controller;

import com.slow.shell.converter.OrderForm2OrderDtoConverter;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.form.OrderForm;
import com.slow.shell.service.BuyerService;
import com.slow.shell.service.OrderService;
import com.slow.shell.service.impl.OrderServiceImpl;
import com.slow.shell.util.ResultVOUtil;
import com.slow.shell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/4 15:48
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private BuyerService buyerService;
	//创建订单
	@PostMapping("/create")
	public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
		if(CollectionUtils.isEmpty(orderDto.getOrderDetailList()))
			throw new SellException(ResultEnum.CART_EMPTY);
		OrderDto createResult = orderService.create(orderDto);
		Map<String,String> map = new HashMap<>();
		map.put("orderId",createResult.getOrderId());
		return ResultVOUtil.success(map);
	}
	//订单列表
	@GetMapping("/list")
	public ResultVO<List<OrderDto>> list(@RequestParam("openid") String openid,
										 @RequestParam(value = "page",defaultValue = "0") Integer page,
										 @RequestParam(value = "size",defaultValue = "10") Integer size){
		if (StringUtils.isEmpty(openid))
			throw new SellException(ResultEnum.PARAM_ERROR);
		PageRequest request = PageRequest.of(page,size);
		Page<OrderDto> orderDtoPage = orderService.findList(openid,request);
		return ResultVOUtil.success(orderDtoPage.get());

	}
	//订单详情
	@GetMapping("/detail")
	public ResultVO<OrderDto> detail(@RequestParam("openid") String openid,
									 @RequestParam("orderId") String orderId){

		OrderDto orderDto = buyerService.findOrderOne(openid,orderId);
		return ResultVOUtil.success(orderDto);
	}
	//取消订单
	@PostMapping("/cancel")
	public ResultVO cancel(@RequestParam("openid") String openid,
						   @RequestParam("orderId") String orderId){
		//TODO 不安全
		buyerService.cancelOrder(openid,orderId);
		return ResultVOUtil.success();
	}
}
