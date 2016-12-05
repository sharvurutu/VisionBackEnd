package com.niit.shoppingcartbackend;

import org.junit.Assert;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;



public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Category category;

	@Autowired
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");

		System.out.println("this objects are created");

	}

	@Test
	public void createCategoryTestCase() {
		category.setId("CAM_5");
		category.setDescription("vision Based1");
		category.setName("Camera1");

		Boolean status = categoryDAO.save(category);

		Assert.assertEquals("create Category Test Case", true, status);

	}

	@Test
	public void deleteCategoryTestCase() {

		category.setId("CAM_03");

		Boolean status = categoryDAO.delete(category);

		Assert.assertEquals("Delete Category Test Case", true, status);
	}

	@Test
	public void updateCategoryTestCase() {
		category.setId("CAM_03");
		category.setDescription("Best sight device");
		category.setName("Vision2");
		Boolean status = categoryDAO.update(category);

		Assert.assertEquals("Update Category Test Case", true, status);
	}

	@Test
	public void getCategoryTestCase() {

		Assert.assertEquals("get Category Test Case", null, categoryDAO.get("abcd"));
	}

	@Test
	public void getAllCategoryTestCase() {

		Assert.assertEquals("get Category Test Case", 4, categoryDAO.list().size());
	}

}
