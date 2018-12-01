package com.slow.shell.service.impl;

import com.slow.shell.dataobject.ProductInfo;
import com.slow.shell.enums.ProductStatusEnum;
import com.slow.shell.repository.ProductInfoRepository;
import com.slow.shell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/1 22:27
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductInfoRepository repository;
	@Override
	public ProductInfo findOne(String productId) {
		return repository.getOne(productId);
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return repository.save(productInfo);
	}
}
