package com.globalmart.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.dao.ProductDao;
import com.globalmart.model.ProductCatalogue;

@RestController
@RequestMapping("/productCatalogue")
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers="Accept=application/json")
	public List<ProductCatalogue> getAllProducts(Model model) {

		logger.debug("In Controller");

		return productDao.findAll();

	}

}