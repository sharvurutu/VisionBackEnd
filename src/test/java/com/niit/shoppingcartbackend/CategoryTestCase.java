package com.niit.shoppingcartbackend;

import org.junit.BeforeClass;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	
	@Autowired
	static Category category;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{	
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}
	
	//@Test
	public void CreateCategoryTestCase()
	{
		category.setId("04");
		category.setDescription("cat");
		category.setName("DSLR");
		boolean status = categoryDAO.save(category);
		Assert.assertEquals("Create Category Test Case", true, status);
		
	}
	
	//@Test
	public void DeleteCategoryTestCase()
	{
		category.setId("01");
		boolean status = categoryDAO.delete(category);
		Assert.assertEquals("Delete Category Test Case", true, status);
	
	}
	//@Test
	public void UpdateCategoryTestCase()
	{
		category.setId("01");
		category.setDescription("Cat");
		category.setName("Rutu");
		boolean status = categoryDAO.update(category);
		Assert.assertEquals("Update Category Test Case", true, status);
		
	}
	
	@Test
	public void GetCategoryTestCase()
	{
		Assert.assertEquals("Get One Category Test Case", null, categoryDAO.get("01"));
	}

	/*@Test
	public void GetAllCategoryTestCase()
	{
		Assert.assertEquals("Get All Category Test Case", 1, categoryDAO.list().size());
		
	}
*/	
}
