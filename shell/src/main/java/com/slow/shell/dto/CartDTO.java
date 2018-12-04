package com.slow.shell.dto;

import lombok.Data;

/**
 * 购物车
 * @author Slicing
 * @date 2018/12/3 17:29
 */
@Data
public class CartDTO {
	/*商品ID*/
	private String productId;
	/*商品数量*/
	private Integer productQuantity;

	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}
