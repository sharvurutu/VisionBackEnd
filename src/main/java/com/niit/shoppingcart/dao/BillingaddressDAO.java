package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Billingaddress;




public interface BillingaddressDAO {

	// CRUD Operations

	public boolean save(Billingaddress billingaddress);

	public boolean update(Billingaddress billingaddress);

	public boolean delete(Billingaddress billingaddress);

	public BillingaddressDAO get(String id);

	public List<BillingaddressDAO> list();

}
