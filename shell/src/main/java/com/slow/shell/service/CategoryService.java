package com.slow.shell.service;

import com.slow.shell.dataobject.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类目
 * @author Slicing
 * @date 2018/12/1 21:21
 */
public interface CategoryService {
	ProductCategory findOne(Integer categoryId);
	List<ProductCategory> findAll();
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	ProductCategory save(ProductCategory productCategory);
}
