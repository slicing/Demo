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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;

	protected User(){

	}
	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
