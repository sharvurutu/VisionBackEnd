package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User order);

	public boolean delete(User user);

	public User get(String id);

	public List<User> list();

	public User isValidUser(String userID, String password);

}
