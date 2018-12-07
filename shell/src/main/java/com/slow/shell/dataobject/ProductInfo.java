package com.slow.shell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slow.shell.enums.OrderStatusEnum;
import com.slow.shell.enums.ProductStatusEnum;
import com.slow.shell.util.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @author Slicing
 * @date 2018/12/1 21:44
 */
@Entity
@Data
@Table(name = "product_info")
@DynamicUpdate
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
	private Integer productStatus = ProductStatusEnum.UP.getCode();
	/*创建时间*/
	private Date createTime;
	/*修改时间*/
	private Date updateTime;


	@JsonIgnore
	public ProductStatusEnum getProductStatusEnum(){
		return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
	}
}
