package com.vebatekno.service;

import java.util.List;

import com.vebatekno.model.User;

public interface UserService {
	
	List<User> findAllUsers();
	User findByUsername(String username);
	User save(User user);
}
