package com.slow.shell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品
 * @author Slicing
 * @date 2018/12/1 21:44
 */
@Entity
@Data
@Table(name = "product_info")
public class ProductInfo {
	@Id
	private String productId;
	/*名字*/
	private String productName;
	/*单价*/
	private BigDecimal productPrice;
	/*库存*/
	private Integer productStock;
	/*描述*/
	private String productDescription;
	/*小图*/
	private String productIcon;

	/*类目编号*/
	private Integer categoryType;
	/*状态，0正常，1下架*/
	private Integer productStatus;
	public ProductInfo() {
	}

	public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productDescription = productDescription;
		this.productIcon = productIcon;
		this.productStatus = productStatus;
		this.categoryType = categoryType;
	}
}
