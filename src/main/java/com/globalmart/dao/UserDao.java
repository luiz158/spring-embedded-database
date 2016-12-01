package com.globalmart.dao;

import java.util.List;

import com.globalmart.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}