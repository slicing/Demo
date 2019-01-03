package com.slow.blog.repository;

import com.slow.blog.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User
 * @author Slicing
 * @date 2019/1/3 10:22
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
