package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.model.ShippingAddress;

import junit.framework.Assert;

public class ShippingAddressTestCase2 {
	
	@Autowired
	static ShippingAddressDAO shippingaddressDAO;
	
	@Autowired
	static ShippingAddress shippingAddress; 
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{	
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		shippingaddressDAO =  (ShippingAddressDAO) context.getBean("shippingaddressDAO");
		shippingAddress =   (ShippingAddress) context.getBean("shippingAddress");
	}
	
	
	@Test
	public void AddShippingAddressTestCase()
	{
		//shippingAddress.setId("SA_001");
		shippingAddress.setAddress_line1("QTR NO 8/3");
		shippingAddress.setAddress_line2("Type-II Rangehills");
		shippingAddress.setCity("Pune");
		shippingAddress.setState("Maharashtra");
		shippingAddress.setPincode("411020");
		boolean status = shippingaddressDAO.save(shippingAddress);
		Assert.assertEquals("BillingAddressCreateTestCase", true, status);
	}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}

}
