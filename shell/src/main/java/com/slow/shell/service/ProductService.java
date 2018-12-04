package com.slow.shell.service;

import com.slow.shell.dataobject.ProductInfo;
import com.slow.shell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/1 21:59
 */
public interface ProductService {
	ProductInfo findOne(String productId);
	/*
	查询所有在架商品列表
	@return
	*/
	List<ProductInfo> findUpAll();

	Page<ProductInfo> findAll(Pageable pageable);//分页

	ProductInfo save(ProductInfo productInfo);
	//加库存
	void increaseStock(List<CartDTO> cartDTOList);
	//减库存
	void decreaseStock(List<CartDTO> cartDTOList);
}
