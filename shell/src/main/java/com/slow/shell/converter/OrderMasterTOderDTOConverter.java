package com.slow.shell.converter;

import com.slow.shell.dataobject.OrderMaster;
import com.slow.shell.dto.OrderDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Slicing
 * @date 2018/12/4 9:02
 */
public class OrderMasterTOderDTOConverter {
	public static OrderDto convert(OrderMaster orderMaster){
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(orderMaster,orderDto);
		return orderDto;
	}
	public static List<OrderDto> convert(List<OrderMaster> orderMasterList){
		return  orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
	}
}
