package com.slow.shell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.slow.shell.dataobject.OrderDetail;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/4 16:31
 */
public class OrderForm2OrderDtoConverter {
	public static OrderDto convert(OrderForm orderForm){
		Gson gson = new Gson();
		OrderDto orderDto = new OrderDto();

		orderDto.setBuyerName(orderForm.getName());
		orderDto.setBuyerPhone(orderForm.getPhone());
		orderDto.setBuyerAddress(orderForm.getAddress());
		orderDto.setBuyerOpenid(orderForm.getOpenid());

		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			orderDetailList = gson.fromJson(orderForm.getItems(),
					new TypeToken<List<OrderDetail>>(){}.getType());
		}catch (Exception e){
			throw new SellException(ResultEnum.PARAM_ERROR);
		}
		orderDto.setOrderDetailList(orderDetailList);
		return orderDto;

	}
}
