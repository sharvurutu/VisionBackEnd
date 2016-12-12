package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.BillingAddress;

public interface BillingAddressDAO {
	
public boolean save(BillingAddress billingaddress);
public boolean delete(BillingAddress billingaddress);
public BillingAddress get(String Id);

	
}
