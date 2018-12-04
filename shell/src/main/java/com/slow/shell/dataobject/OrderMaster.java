package com.slow.shell.dataobject;

import com.slow.shell.enums.OrderStatusEnum;
import com.slow.shell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Slicing
 * @date 2018/12/2 22:17
 */
@Entity
@DynamicUpdate
@Table(name = "order_master")
@Data
public class OrderMaster {
	/*订单ID*/
	@Id
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
	private Integer orderStatus = OrderStatusEnum.NEW.getCode();
	/*支付状态 0默认未支付*/
	private Integer payStatus = PayStatusEnum.WAIT.getCode();
	/*创建时间*/
	private Date createTime;
	/*更新时间*/
	private Date updateTime;


}
