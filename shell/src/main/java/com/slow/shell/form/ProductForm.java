package com.slow.shell.form;

import com.slow.shell.enums.ProductStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Slicing
 * @date 2018/12/7 17:10
 */
@Data
public class ProductForm {
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
	private Integer productStatus = ProductStatusEnum.UP.getCode();
}
