package com.slow.blog.dataobject;

import lombok.Data;


import javax.persistence.*;

/**
 * 实体
 * @author Slicing
 * @date 2019/1/3 10:10
 */
@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
