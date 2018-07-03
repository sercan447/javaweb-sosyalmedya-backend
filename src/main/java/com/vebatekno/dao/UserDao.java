package com.vebatekno.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vebatekno.model.User;



@Repository
public interface UserDao extends CrudRepository<User, Long> {
	List<User> findAll();
		
	//@Query("select u from User u where u.username = :username")
	User findByUsername(/*@Param("username")*/String username);
	
	User findByUserId(Long userId);
	
	User save(User user);
	
	
}
