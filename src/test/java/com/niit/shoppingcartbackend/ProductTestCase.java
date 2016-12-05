package com.niit.shoppingcartbackend;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;


public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Product product;

	@Autowired
	static ProductDAO productDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");

		System.out.println("this objects are created");

	}

	@Test
	public void createproductTestCase() {
		product.setId("PRO_6");

		product.setName("CAMERA6");
		product.setPrice(4892902);
		product.setC_id("CAM_4");
		product.setS_id("SUP_5");
		product.setStock(87654);

		Boolean status = productDAO.save(product);

		Assert.assertEquals("create product Test Case", true, status);

	}

	@Test
	public void deleteproductTestCase() {

		product.setId("PRO_4");
		Boolean status = productDAO.delete(product);

		Assert.assertEquals("Delete product Test Case", true, status);
	}

	@Test
	public void updateproductTestCase() {
		product.setId("PRO_6");

		product.setName("CAMERA6");
		product.setPrice(48929);
		product.setC_id("CAM_4");
		product.setS_id("SUP_5");
		product.setStock(876);

		Boolean status = productDAO.update(product);

		Assert.assertEquals("Update product Test Case", true, status);
	}

	@Test
	public void getProductTestCase() {

		Assert.assertEquals("get Product Test Case", null, productDAO.get("abcd"));
	}

	@Test
	public void getAllProductTestCase() {

		Assert.assertEquals("get Product Test Case", 5, productDAO.list().size());
	}

}
