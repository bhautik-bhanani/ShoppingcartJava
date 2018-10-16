/**
 * 
 */
package com.shop.mvc.dao.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.shop.mvc.controllers.HomeController;
import com.shop.mvc.dao.UserDAO;
import com.shop.mvc.dao.rowmapper.UserRowMapper;
import com.shop.mvc.model.User;

/**
 * @author Bhautik Bhanani
 *
 */
@Repository(value = "UserDAOImpl")
public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	SimpleJdbcInsert jdbcInsert;
	UserRowMapper userRowMapper;

	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		userRowMapper = new UserRowMapper();
	}

	@Override
	public User getUserByEmailAndPass(String email, String password) {
		String sql = "SELECT * FROM jdbc_user WHERE email = ? AND password = ?";
		Object[] params = { email, password };
		return jdbcTemplate.queryForObject(sql, params, userRowMapper);
	}

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM jdbc_user WHERE userId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { userId }, userRowMapper);
	}

	@Override
	public boolean addWishlist(int userId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWishlist(int userId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM jdbc_user WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { email }, userRowMapper);
	}
}
