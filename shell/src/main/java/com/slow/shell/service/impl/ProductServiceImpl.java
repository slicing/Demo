package com.slow.shell.service.impl;

import com.slow.shell.dataobject.ProductInfo;
import com.slow.shell.dto.CartDTO;
import com.slow.shell.enums.ProductStatusEnum;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import com.slow.shell.repository.ProductInfoRepository;
import com.slow.shell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

	@Override
	@Transactional
	public void increaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO : cartDTOList){
			ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
			if (productInfo == null)
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
			productInfo.setProductStock(result);
			repository.save(productInfo);
		}
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO : cartDTOList){
			ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
			if (productInfo == null){
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if (result < 0)
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			productInfo.setProductStock(result);
			repository.save(productInfo);
		}
	}
}
