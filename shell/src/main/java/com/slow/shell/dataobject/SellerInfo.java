package com.slow.shell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Slicing
 * @date 2018/12/8 20:33
 */
@Data
@Entity
@Table(name = "seller_info")
public class SellerInfo {

	@Id
	private String sellerId;

	private String username;

	private String password;

	private String openid;



}
