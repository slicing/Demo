package com.slow.shell.service.impl;

import com.slow.shell.dataobject.SellerInfo;
import com.slow.shell.repository.SellerInfoRepository;
import com.slow.shell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Slicing
 * @date 2018/12/8 21:21
 */
@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	private SellerInfoRepository sellerInfoRepository;

	/**
	 *
	 * @param openid
	 * @return
	 */
	@Override
	public SellerInfo findSellerInfoByOpenid(String openid) {
		SellerInfo sellerInfo = sellerInfoRepository.findByOpenid(openid);
		return sellerInfo;
	}
}
