package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {

	// CRUD Operations

	public Category get(String id);

	public List<Category> list();

	public boolean saveOrUpdate(Category category);

	public boolean delete(String id);

}
