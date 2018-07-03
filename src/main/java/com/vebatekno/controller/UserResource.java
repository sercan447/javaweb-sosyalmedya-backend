package com.vebatekno.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vebatekno.model.User;
import com.vebatekno.service.UserService;
import com.vebatekno.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/rest")
public class UserResource {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/user/users")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/user/userName",method=RequestMethod.POST)
	public User findByUserName(@RequestBody String userName)
	{
		
		return userService.findByUsername(userName);
	}
	
	
	@RequestMapping(value="/user/update",method=RequestMethod.POST)
	public User updateUser(@RequestBody User user)
	{
		return userService.save(user);
	}
}
