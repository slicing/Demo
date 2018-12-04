package com.slow.shell.service.impl;


import com.slow.shell.converter.OrderMasterTOderDTOConverter;
import com.slow.shell.dataobject.OrderDetail;
import com.slow.shell.dataobject.OrderMaster;
import com.slow.shell.dataobject.ProductInfo;
import com.slow.shell.dto.CartDTO;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.enums.OrderStatusEnum;
import com.slow.shell.enums.PayStatusEnum;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.repository.OrderDetailRespository;
import com.slow.shell.repository.OrderMasterRespository;
import com.slow.shell.service.OrderService;
import com.slow.shell.service.ProductService;
import com.slow.shell.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Slicing
 * @date 2018/12/3 16:58
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderDetailRespository orderDetailRespository;
	@Autowired
	private OrderMasterRespository orderMasterRespository;
	@Override
	@Transactional
	public OrderDto create(OrderDto orderDto) {
		String orderId = KeyUtil.genUnitqueKey();
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
		//1.查询商品（数量，价格）
		for (OrderDetail orderDetail : orderDto.getOrderDetailList()){
			ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
			if (productInfo == null){
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//2.计算总价
			orderAmount = productInfo.getProductPrice()
					.multiply(new BigDecimal(orderDetail.getProductQuantity()))
					.add(orderAmount);
			//订单详情入库
			BeanUtils.copyProperties(productInfo,orderDetail);
			orderDetail.setDetailId(KeyUtil.genUnitqueKey());
			orderDetail.setOrderId(orderId);

			orderDetailRespository.save(orderDetail);
		}
		//写入订单数据库
		OrderMaster orderMaster = new OrderMaster();
		orderDto.setOrderId(orderId);
		BeanUtils.copyProperties(orderDto,orderMaster);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMaster.setOrderAmount(orderAmount);
		orderMasterRespository.save(orderMaster);
		//扣库存
		List<CartDTO> cartDTOList = orderDto.getOrderDetailList().stream()
				.map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
				.collect(Collectors.toList());
		productService.decreaseStock(cartDTOList);
		return orderDto;
	}

	@Override
	public OrderDto findOne(String OrderId) {
		 OrderMaster orderMaster =  orderMasterRespository.getOne(OrderId);
		 if (orderMaster == null)
		 	throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		 List<OrderDetail> orderDetailList = orderDetailRespository.findByOrderId(OrderId);
		 if (CollectionUtils.isEmpty(orderDetailList))
		 	throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
		 OrderDto orderDto = new OrderDto();
		 BeanUtils.copyProperties(orderMaster,orderDto);
		 orderDto.setOrderDetailList(orderDetailList);
		 return orderDto;
	}

	@Override
	public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
		Page<OrderMaster> orderMasterPage = orderMasterRespository.findByBuyerOpenid(buyerOpenid,pageable);
		List<OrderDto> orderDtoList = OrderMasterTOderDTOConverter.convert(orderMasterPage.getContent());
		Page<OrderDto> orderDtoPage = new PageImpl<OrderDto>(orderDtoList,pageable,orderMasterPage.getTotalElements());
		return orderDtoPage;
	}

	@Override
	@Transactional
	public OrderDto cancel(OrderDto orderDto) {
		OrderMaster orderMaster = new OrderMaster();
		//判断订单状态
		if(!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode()))
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		//修改状态
		orderDto.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
		BeanUtils.copyProperties(orderDto,orderMaster);
		OrderMaster updateResult = orderMasterRespository.save(orderMaster);
		if (updateResult == null)
			throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		//返回库存
		if (CollectionUtils.isEmpty(orderDto.getOrderDetailList()))
			throw new SellException(ResultEnum.ORDER_DETAIL_EMPLY);
		List<CartDTO> cartDTOList = orderDto.getOrderDetailList().stream()
				.map(e->new CartDTO(e.getProductId(),e.getProductQuantity()))
				.collect(Collectors.toList());
		productService.increaseStock(cartDTOList);
		//如果已支付退款
		if (orderDto.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
			//TODO
		}
		return orderDto;
	}

	@Override
	@Transactional
	public OrderDto finish(OrderDto orderDto) {
		//判断订单状态
		if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
			throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
		}
		//修改状态
		orderDto.setOrderStatus(OrderStatusEnum.FINISGED.getCode());
		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDto,orderMaster);
		OrderMaster updateResult = orderMasterRespository.save(orderMaster);
		if(updateResult == null)
			throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		return orderDto;

	}

	@Override
	@Transactional
	public OrderDto paid(OrderDto orderDto) {
		//判断订单状态
		if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		//判断支付状态
		if(!orderDto.getPayStatus().equals(PayStatusEnum.WAIT.getCode()))
			throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
		//修改支付状态
		orderDto.setPayStatus(PayStatusEnum.SUCCESS.getCode());
		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDto,orderMaster);
		OrderMaster updateResult = orderMasterRespository.save(orderMaster);
		if(updateResult == null)
			throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		return orderDto;
	}
}
