package com.slow.shell.service.impl;

import com.slow.shell.dataobject.ProductCategory;
import com.slow.shell.repository.ProductCategoryRepository;
import com.slow.shell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/1 21:24
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	@Override
	public ProductCategory findOne(Integer categoryId) {
		return productCategoryRepository.getOne(categoryId);
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}
}
