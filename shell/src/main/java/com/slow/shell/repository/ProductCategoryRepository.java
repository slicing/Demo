package com.slow.shell.repository;

import com.slow.shell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/1 14:10
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
