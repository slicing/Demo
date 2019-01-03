package com.slow.blog.service;

import com.slow.blog.dataobject.User;

import java.util.List;

/**
 * @author Slicing
 * @date 2019/1/3 10:26
 */
public interface UserService {
	/**
	 * 创建或修改
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Long id);

	/**
	 * 查询ID
	 * @param id
	 * @return
	 */
	User getUserById(Long id);

	/**
	 * 获取用户
	 * @return
	 */
	List<User> listUser();

}
