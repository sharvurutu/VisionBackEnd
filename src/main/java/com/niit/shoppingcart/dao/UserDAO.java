package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {
	
	public boolean save(User user);
	public boolean delete(User user);
	public boolean update(User user);
	public User get(String userId);
	public User IsValidUser(String email, String password);
	public List<User> list();

}
/*package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {
	
	public boolean save(User user);
	public boolean delete(User user);
	public boolean update(User user);
	public User get(String userId);
	public User IsValidUser(String email, String password);

	public List<User> list();

}
*/