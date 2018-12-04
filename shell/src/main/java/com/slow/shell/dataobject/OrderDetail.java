package com.slow.shell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Slicing
 * @date 2018/12/2 22:35
 */
@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	private String detailId;
	/*订单ID*/
	private String orderId;
	/*商品id*/
	private String productId;
	/*商品名称*/
	private String productName;
	/*商品价格*/
	private BigDecimal productPrice;
	/*商品数量*/
	private Integer productQuantity;
	/*商品小图*/
	private String productIcon;
}
