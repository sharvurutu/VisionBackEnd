package com.niit.shoppingcartbackend;

import org.junit.Assert;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingaddressDAO;
import com.niit.shoppingcart.model.Billingaddress;



public class BillingaddressTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Billingaddress billingaddress;

	@Autowired
	static BillingaddressDAO billingaddressDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		billingaddressDAO = (BillingaddressDAO) context.getBean("billingaddressDAO");
		billingaddress = (Billingaddress) context.getBean("billingaddress");

		System.out.println("this objects are created");

	}

	@Test
	public void createBillingaddressTestCase() {
		billingaddress.setId("BL_4");
		billingaddress.setH_no("Matrukrupa 9094");
		billingaddress.setStreet("MUMBAI ROAD");
		billingaddress.setCity("PUNE");
		billingaddress.setCountry("INDIA");
		billingaddress.setPin("26011994");

		Boolean status = billingaddressDAO.save(billingaddress);

		Assert.assertEquals("create Billingaddress Test Case", true, status);

	}

	@Test
	public void deleteBillingaddressTestCase() {

		billingaddress.setId("BL_3");

		Boolean status = billingaddressDAO.delete(billingaddress);

		Assert.assertEquals("Delete Billingaddress Test Case", true, status);
	}

	@Test
	public void updateBillingaddressTestCase() {
		billingaddress.setId("BL_1");
		billingaddress.setH_no("Sharvari 9094");

		Boolean status = billingaddressDAO.update(billingaddress);

		Assert.assertEquals("Update Billingaddress Test Case", true, status);
	}

	@Test
	public void getBillingaddressTestCase() {

		Assert.assertEquals("get Billingaddress Test Case", null, billingaddressDAO.get("abcd"));
	}

	@Test
	public void getAllBillingaddressTestCase() {

		Assert.assertEquals("get Billingaddress Test Case", 3, billingaddressDAO.list().size());
	}

}
