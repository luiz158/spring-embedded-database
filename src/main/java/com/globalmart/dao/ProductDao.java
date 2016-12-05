package com.globalmart.dao;

import java.util.List;

import com.globalmart.model.ProductCatalogue;

public interface ProductDao {

	ProductCatalogue findByName(String name);
	
	List<ProductCatalogue> findAll();
	
	void add(ProductCatalogue product);
	
	void remove(String id);

}