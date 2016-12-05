package com.niit.shoppingcartbackend;

import org.junit.Assert;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;


public class UserTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static User user;

	@Autowired
	static UserDAO userDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");

		System.out.println("this objects are created");

	}

	@Test
	public void createuserTestCase() {
		user.setId("U_4");
		user.setName("PURVA");
		user.setPassword("PURVI");
		user.setContact(98765431);
		user.setRole("USER");
		user.setAddress("VAJIRABAD,NANDED");
		user.setMail("purva@gmail.com");

		Boolean status = userDAO.save(user);

		Assert.assertEquals("create user Test Case", true, status);

	}

	@Test
	public void deleteuserTestCase() {

		user.setId("U_1");
		Boolean status = userDAO.delete(user);

		Assert.assertEquals("Delete user Test Case", true, status);
	}

	@Test
	public void updateuserTestCase() {
		user.setId("U_4");

		user.setPassword("PURVA1");

		Boolean status = userDAO.update(user);

		Assert.assertEquals("Update user Test Case", true, status);
	}

	@Test
	public void getuserTestCase() {

		Assert.assertEquals("get user Test Case", null, userDAO.get("abcd"));
	}

	@Test
	public void getAlluserTestCase() {

		Assert.assertEquals("get user Test Case", 4, userDAO.list().size());
	}

}
