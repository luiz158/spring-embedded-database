package com.globalmart.dao;

import java.util.List;

import com.globalmart.model.Product;

public interface ProductDao {

	Product findByName(String name);
	
	List<Product> findAll();

}