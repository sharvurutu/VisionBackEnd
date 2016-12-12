package com.niit.shoppingcart.dao;

import java.util.List;


import com.niit.shoppingcart.model.Cart;

public interface CartDAO {

	public List<Cart> list(String Id);
	public boolean Save(Cart cart);
	public boolean delete(String Id);
	public boolean update(Cart cart);
	public Integer getMaxId();
	public boolean deleteByCartId(Cart cart);
	public Cart get(Integer Id);
	public Long get_TotalAmount(String Id);
}
