package com.niit.shoppingcartbackend;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ShippingaddressDAO;
import com.niit.shoppingcart.model.Shippingaddress;



public class ShippingaddressTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Shippingaddress shippingaddress;

	@Autowired
	static ShippingaddressDAO shippingaddressDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		shippingaddressDAO = (ShippingaddressDAO) context.getBean("shippingaddressDAO");
		shippingaddress = (Shippingaddress) context.getBean("shippingaddress");

		System.out.println("this objects are created");

	}

	@Test
	public void createShippingaddressTestCase() {
		shippingaddress.setId("SH_3");
		shippingaddress.setH_no("ANUBANDH 1926");
		shippingaddress.setStreet("SUNCITY ROAD");
		shippingaddress.setCity("MUMBAI");
		shippingaddress.setCountry("INDIA");
		shippingaddress.setPin("410401");

		Boolean status = shippingaddressDAO.save(shippingaddress);

		Assert.assertEquals("create Billingaddress Test Case", true, status);

	}

	@Test
	public void deleteShippingaddressTestCase() {

		shippingaddress.setId("BL_3");

		Boolean status = shippingaddressDAO.delete(shippingaddress);

		Assert.assertEquals("Delete Shippingaddress Test Case", true, status);
	}

	@Test
	public void updateShippingaddressTestCase() {
		shippingaddress.setId("BL_1");
		shippingaddress.setH_no("Pitruchaya 9094");

		Boolean status = shippingaddressDAO.update(shippingaddress);

		Assert.assertEquals("Update Shippingaddress Test Case", true, status);
	}

	@Test
	public void getShippingaddressTestCase() {

		Assert.assertEquals("get Shippingaddress Test Case", null, shippingaddressDAO.get("abcd"));
	}

	@Test
	public void getAllShippingaddressTestCase() {

		Assert.assertEquals("get Shippingaddress Test Case", 2, shippingaddressDAO.list().size());
	}

}
