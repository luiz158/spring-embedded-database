package com.globalmart.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.globalmart.dao.ProductDao;
import com.globalmart.dao.ProductDaoImpl;
import com.globalmart.model.Product;

public class UserDaoTest {

    private EmbeddedDatabase db;

    ProductDao userDao;
    
    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.H2)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-data.sql")
    		.build();
    }

    @Test
    public void testFindByname() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	ProductDaoImpl userDao = new ProductDaoImpl();
    	userDao.setNamedParameterJdbcTemplate(template);
    	
    	Product user = userDao.findByName("mkyong");
  
    	Assert.assertNotNull(user);
    	Assert.assertEquals(1, user.getId().intValue());
    	Assert.assertEquals("mkyong", user.getName());
    	Assert.assertEquals("mkyong@gmail.com", user.getCategory());

    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}