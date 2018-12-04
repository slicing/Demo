package com.slow.shell.repository;

import com.slow.shell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Slicing
 * @date 2018/12/2 22:39
 */
public interface OrderMasterRespository extends JpaRepository<OrderMaster,String> {
	Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
