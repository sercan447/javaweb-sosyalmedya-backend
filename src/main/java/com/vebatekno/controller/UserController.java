package com.vebatekno.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vebatekno.model.User;
import com.vebatekno.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestBody Map<String,String> json)throws ServletException {
		
		if(json.get("username") == null || json.get("password") == null) {
			throw new ServletException("Pleease fill in username and password");
		}
		
		String userName = json.get("username");
		String password = json.get("password");
		
		User user = userService.findByUsername(userName);
		
		if(user == null)
		{
			throw new ServletException("User name not found");
		}
		
		String pwd = user.getPassword();
	
		if(!password.equals(pwd)) {
			throw new ServletException("Invalid login.Please check your username and password");
		}
			
		//return "redirect:/home";
		return Jwts.builder().setSubject(userName).claim("roles","user")
												   .setIssuedAt(new Date())
												   .signWith(SignatureAlgorithm.HS256, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
												   .compact();
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public User registerUser(@RequestBody User user)
	{
		return userService.save(user);
	}
	
	
	
	
}
