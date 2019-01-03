package com.slow.blog.service.impl;

import com.slow.blog.dataobject.User;
import com.slow.blog.repository.UserRepository;
import com.slow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User impl
 * @author Slicing
 * @date 2019/1/3 10:31
 */
@Service
public class UserServiceImpl implements UserService {
	private static AtomicLong counter = new AtomicLong();
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		User user = repository.getOne(id);
		repository.delete(user);
	}

	@Override
	public User getUserById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<User> listUser() {
		return repository.findAll();
	}
}
