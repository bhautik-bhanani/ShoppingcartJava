/**
 * 
 */
package com.shop.mvc.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.shop.mvc.controllers.HomeController;
import com.shop.mvc.dao.ProductDAO;
import com.shop.mvc.dao.rowmapper.ProductRowMapper;
import com.shop.mvc.model.Product;

/**
 * @author Bhautik Bhanani
 *
 */
@Repository(value = "ProductDAOImpl")
public class ProductDAOImpl implements ProductDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	SimpleJdbcInsert jdbcInsert;
	ProductRowMapper productRowMapper;

	/**
	 * 
	 */
	@PostConstruct
	public void setup() {
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		productRowMapper = new ProductRowMapper();
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductList() {
		String sql = "SELECT jdbc_product.*,jdbc_type.typeName FROM jdbc_product LEFT JOIN jdbc_type ON jdbc_product.typeId=jdbc_type.typeId";
		List<Product> products = jdbcTemplate.query(sql, productRowMapper);
		return products;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product updateProduct(Product product, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

}
