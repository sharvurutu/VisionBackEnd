package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.MyCart;

public interface CartDAO {
	public void save(MyCart MyCart);

	public void update(MyCart Mycart);

	public String delete(String id);

	public MyCart get(String id);

	public List<MyCart> list(String id);

	public Long getTotalAmount(String id);
}
