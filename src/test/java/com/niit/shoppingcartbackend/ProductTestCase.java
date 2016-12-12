package com.niit.shoppingcartbackend;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

import junit.framework.Assert;

public class ProductTestCase {

	
	@Autowired
	static Product product;
	
	@Autowired
	static ProductDAO productDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{	
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}
	
	//@Test
	public void CreateProductTestCase()
	{
		product.setId("P002");
		product.setName("Product2");
		product.setPrice(1000);
		product.setStock(2);
		product.setC_Id("Sports_001");
		product.setSupplier_Id("Sup2");
boolean status = productDAO.save(product);
		Assert.assertEquals("Create Product Test Case", true, status);
		
	}
	
	//@Test
	public void DeleteProductTestCase()
	{
		product.setId("Y001");
		boolean status = productDAO.delete(product);
		Assert.assertEquals("Delete Product Test Case", true, status);
	
	}

	//@Test
	/*public void UpdateProductTestCase()
	{
		Product.setId("Y001");
		Product.setDescription("Yamaha1223");
		Product.setName("ankur");
		boolean status = productDAO.update(product);
		Assert.assertEquals("Update Product Test Case", true, status);
		
	}
	*/
	//@Test
	public void GetProductTestCase()
	{
		Assert.assertEquals("Get One Product Test Case", 1, productDAO.get("P003"));
	}

	
	@Test
	public void GetProductBynameTestCase()
	{
		Assert.assertEquals("Get One Product Test Case", 1, productDAO.getByName("Product3"));
	}

	
	//@Test
	public void GetAllProductTestCase()
	{
		Assert.assertEquals("Get All Product Test Case", 1, productDAO.list().size());
		
	}

}
