package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;




public interface CartDAO {
	public void save(Cart cart);

	public void update(Cart cart);

	public String delete(Cart cart);

	public MyCart get(String id);

	public List<MyCart> list(String id);
	
	public Long getTotalAmount(String id);

	public void saveOrUpdate(Cart cart);

	public void delete(int id);

	public Object getTotalAmount(int total);

}
