package com.waylau.spring.boot.repository;

import java.util.List;

import com.waylau.spring.boot.blog.domain.User;

public interface UserRepository {

	User saveOrUpdateUser(User user);
	
	void deleteUser(Long id);
	
	User gerUserById(Long id);
	
	List<User> listUsers();
}
