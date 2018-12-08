package com.slow.shell.repository;

import com.slow.shell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Slicing
 * @date 2018/12/8 20:36
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
	SellerInfo findByOpenid(String openId);
}
