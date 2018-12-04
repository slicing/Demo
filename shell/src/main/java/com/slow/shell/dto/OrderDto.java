package com.slow.shell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slow.shell.dataobject.OrderDetail;
import com.slow.shell.enums.OrderStatusEnum;
import com.slow.shell.enums.PayStatusEnum;
import com.slow.shell.util.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/3 16:53
 */
@Data
public class OrderDto {
	/*订单ID*/
	private String orderId;
	/*买家名字*/
	private String buyerName;
	/*买家电话*/
	private String buyerPhone;
	/*买家地址*/
	private String buyerAddress;
	/*买家微信号*/
	private String buyerOpenid;
	/*订单总金额*/
	private BigDecimal orderAmount;
	/*订单状态，0新订单，1完结，2取消*/
	private Integer orderStatus;
	/*支付状态 0默认未支付*/
	private Integer payStatus;
	/*创建时间*/
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date createTime;
	/*更新时间*/
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date updateTime;

	List<OrderDetail> orderDetailList;
}
