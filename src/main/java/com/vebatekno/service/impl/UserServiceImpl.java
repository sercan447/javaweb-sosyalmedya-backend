package com.vebatekno.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vebatekno.dao.UserDao;
import com.vebatekno.model.User;
import com.vebatekno.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAllUsers() {
		
		return userDao.findAll();
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	@Override
	public User save(User user) {
		
		return userDao.save(user);
	}

	

}
