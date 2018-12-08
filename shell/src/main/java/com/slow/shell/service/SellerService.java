package com.slow.shell.service;

import com.slow.shell.dataobject.SellerInfo;

/**
 * @author Slicing
 * @date 2018/12/8 20:42
 */
public interface SellerService {
	/**
	 * 通过openid查询卖家端信息
	 * @param open
	 * @return
	 */
	SellerInfo findSellerInfoByOpenid(String open);

}
