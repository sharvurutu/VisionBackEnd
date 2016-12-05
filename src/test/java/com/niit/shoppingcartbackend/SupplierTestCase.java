package com.niit.shoppingcartbackend;

import org.junit.Assert;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class SupplierTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Supplier supplier;

	@Autowired
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");

		System.out.println("this objects are created");

	}

	@Test
	public void createSupplierTestCase() {
		supplier.setId("SUP_7");
		supplier.setAddress("VASHI");
		supplier.setName("PANASONIC");

		Boolean status = supplierDAO.save(supplier);

		Assert.assertEquals("create Supplier Test Case", true, status);

	}

	@Test
	public void deleteSupplierTestCase() {

		supplier.setId("SUP_07");
		Boolean status = supplierDAO.delete(supplier);

		Assert.assertEquals("Delete  Supplier Test Case", true, status);
	}

	@Test
	public void updateSupplierTestCase() {
		supplier.setId("SUP_6");
		supplier.setAddress("BANDRA");
		supplier.setName("FUJIFILM1");
		Boolean status = supplierDAO.update(supplier);

		Assert.assertEquals("Update  Supplier Test Case", true, status);
	}

	@Test
	public void getSupplierTestCase() {

		Assert.assertEquals("get  Supplier Test Case", null, supplierDAO.get("abcd"));
	}

	@Test
	public void getAllSupplierTestCase() {

		Assert.assertEquals("get Supplier Test Case", 7, supplierDAO.list().size());
	}

}
