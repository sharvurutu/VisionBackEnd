package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.ShippingAddress;

public interface ShippingAddressDAO {
public boolean save(ShippingAddress shippingaddress);
public boolean delete(ShippingAddress shippingaddress);
public ShippingAddress get(String Id);	
	
}
