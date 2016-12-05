package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;

public interface OrderDAO {

	// CRUD Operations

	public boolean save(Order order);

	public boolean update(Order order);

	public boolean delete(Order order);

	public Order get(String id);

	public List<Order> list();

}
