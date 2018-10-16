/**
 * 
 */
package com.shop.mvc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shop.mvc.model.Product;

/**
 * @author Bhautik Bhanani
 *
 */
public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getInt("productId"));
		product.setProductName(rs.getString("productName"));
		product.setProductDesc(rs.getString("productDesc"));
		product.setProductImg(rs.getString("productImg"));
		product.setProductPrice(rs.getDouble("productPrice"));
		product.setTypeName(rs.getString("typeName"));
		return product;
	}
}
