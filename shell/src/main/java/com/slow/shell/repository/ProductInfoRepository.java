package com.slow.shell.repository;

import com.slow.shell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/1 21:49
 */
public interface ProductInfoRepository  extends JpaRepository<ProductInfo,String> {
	List<ProductInfo> findByProductStatus(Integer productStatus);
}
