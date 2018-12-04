package com.slow.shell.repository;

import com.slow.shell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/2 22:41
 */
public interface OrderDetailRespository extends JpaRepository<OrderDetail,String> {
	List<OrderDetail> findByOrderId(String orderId);
}
