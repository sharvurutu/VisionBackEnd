package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	public Supplier get(String id);

	public List<Supplier> list();

	public boolean saveOrUpdate(Supplier supplier);

	public boolean delete(String id);

}
