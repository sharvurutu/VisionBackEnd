package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.Order;

public interface UserOrderDAO {
	
	public boolean save(Order userorder);
	public boolean delete(Order userorder);
	public Order get(String Id);

}
