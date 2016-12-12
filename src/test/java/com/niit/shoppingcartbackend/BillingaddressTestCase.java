package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.model.BillingAddress;

import junit.framework.Assert;

public class BillingAddressTestCase {
	
	@Autowired
	static BillingAddressDAO billingaddressDAO;
	
	@Autowired
	static BillingAddress billingAddress; 
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{	
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		billingaddressDAO = (BillingAddressDAO) context.getBean("billingaddressDAO");
		billingAddress =  (BillingAddress) context.getBean("billingAddress");
	}
	
	
	@Test
	public void AddBillingAddressTestCase()
	{
		//billingAddress.setId("BA_001");
		billingAddress.setAddress_line1("QTR NO 8/3");
		billingAddress.setAddress_line2("Type-II Rangehills");
		billingAddress.setCity("Pune");
		billingAddress.setState("Maharashtra");
		billingAddress.setPincode("411020");
		boolean status = billingaddressDAO.save(billingAddress);
		Assert.assertEquals("BillingAddressCreateTestCase", true, status);
	}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}

}
