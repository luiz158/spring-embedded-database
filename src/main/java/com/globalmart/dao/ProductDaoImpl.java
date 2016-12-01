package com.globalmart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.globalmart.model.ProductCatalogue;

@Repository
public class ProductDaoImpl implements ProductDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public ProductCatalogue findByName(String name) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        
		String sql = "SELECT * FROM product_catalogue WHERE name=:name";
		
        ProductCatalogue result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new UserMapper());
                    
        return result;
        
	}

	@Override
	public List<ProductCatalogue> findAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM product_catalogue";
		
        List<ProductCatalogue> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());
        
        return result;
        
	}

	private static final class UserMapper implements RowMapper<ProductCatalogue> {

		public ProductCatalogue mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductCatalogue productCatalogue = new ProductCatalogue();
			productCatalogue.setProductId(rs.getInt("id"));
			productCatalogue.setProductName(rs.getString("name"));
			productCatalogue.setProductType(rs.getString("category"));
			productCatalogue.setPrice(rs.getDouble("price"));
			return productCatalogue;
		}
	}

}