package com.shop.mvc.dao;

import com.shop.mvc.model.User;

/**
 * @author Bhautik Bhanani
 *
 */
public interface UserDAO {
	/**
	 * @param email
	 * @param password
	 * @return User
	 */
	public abstract User getUserByEmailAndPass(String email, String password);

	/**
	 * @param userId
	 * @return user
	 */
	public abstract User getUserById(int userId);

	/**
	 * @param email
	 * @return user
	 */
	public abstract User getUserByEmail(String email);

	/**
	 * @param userId
	 * @param productId
	 * @param user
	 * @param product
	 * @return boolean
	 */
	public abstract boolean addWishlist(int userId, int productId);

	/**
	 * @param userId
	 * @param productId
	 * @return boolean
	 */
	public abstract boolean removeWishlist(int userId, int productId);
}
