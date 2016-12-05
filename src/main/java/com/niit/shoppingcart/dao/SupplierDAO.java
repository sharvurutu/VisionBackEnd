package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	Supplier get(String id);

	List<Supplier> list();

	Boolean save(Supplier supplier);

	Boolean update(Supplier supplier);

	Boolean delete(Supplier supplier);

}
