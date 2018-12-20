package com.slow.oversea.converter;

import com.slow.oversea.dataobject.ApplicationTable;
import com.slow.oversea.dto.CartDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Slicing
 * @date 2018/12/19 19:00
 */
public class ApplicationTableTCardDTOConverter {
	public static CartDTO convert(ApplicationTable applicationTable){
		CartDTO cartDTO = new CartDTO();
		BeanUtils.copyProperties(applicationTable,cartDTO);
		return cartDTO;
	}
	public static List<CartDTO> convert(List<ApplicationTable> applicationTableList){
		return  applicationTableList.stream().map(e -> convert(e)).collect(Collectors.toList());
	}
}
