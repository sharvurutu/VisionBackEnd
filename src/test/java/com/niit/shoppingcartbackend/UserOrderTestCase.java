package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserOrderDAO;
import com.niit.shoppingcart.model.Order;

import junit.framework.Assert;

public class UserOrderTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static UserOrderDAO userorderDAO;
	
	@Autowired
	static Order userOrder;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userorderDAO = (UserOrderDAO) context.getBean("userorderDAO");
		userOrder =  (Order) context.getBean("userOrder");
	}
	
	
	@Test
	public void CreateuserOrderTestCase()
	{
		userOrder.setProduct_Name("gkgkjg");
		userOrder.setProduct_Price(67);
		userOrder.setUser_Id("mbmm");
		boolean status= userorderDAO.save(userOrder);
		Assert.assertEquals("CreateuserOrderTestCase", true, status);
	}

}
