package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
	
	public boolean save(Category category);		//To insert a Category
	
	public boolean update(Category category);	//To update a Category
	
	public boolean delete(Category category);	//To delete a Category
	
	public Category get(String id);			    //To get Category of Particular Id
	
	public List<Category> list();				//To get whole Category table
}
