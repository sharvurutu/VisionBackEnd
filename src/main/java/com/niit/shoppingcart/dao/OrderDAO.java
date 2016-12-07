package com.niit.shoppingcart.dao;

import java.util.List;


import com.niit.shoppingcart.model.Order;

public interface OrderDAO {

	// CRUD Operations
	
	public Order get(String id);

	public List<Order> list();

	public boolean saveOrUpdate(Order order);

	public boolean delete(String id);

}
