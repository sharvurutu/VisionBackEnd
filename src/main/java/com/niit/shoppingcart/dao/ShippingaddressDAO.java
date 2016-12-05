package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Shippingaddress;

public interface ShippingaddressDAO {

	// CRUD Operations

	public boolean save(Shippingaddress shippingaddress);

	public boolean update(Shippingaddress shippingaddress);

	public boolean delete(Shippingaddress shippingaddress);

	public ShippingaddressDAO get(String id);

	public List<ShippingaddressDAO> list();

}
