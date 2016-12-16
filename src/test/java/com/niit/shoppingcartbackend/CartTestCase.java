package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

import junit.framework.Assert;

public class CartTestCase {
	
	@Autowired
	SessionFactory sessionFactory;


	@Autowired
	static Cart cart;
	
	@Autowired
	static CartDAO cartDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cart = (Cart) context.getBean("cart");
		cartDAO = (CartDAO) context.getBean("cartDAO");
		
	}
	
//@Test
	public void CreateCartTestCase()
	{
		cart.setId(101);
		cart.setUser_Id("rutu956177@gmail.com");
		cart.setPrice(90000);
		cart.setProduct_Name("dslr");
		boolean status = cartDAO.Save(cart);
		Assert.assertEquals("CreateCartTestCase", true, status);
		}

	
	//@Test
	public void DeleteCartTestCase()
	{
		//cart.setId("001");
//		Assert.assertEquals("DeleteCartTestCase", true, status);
	}
	
	//@Test
	public void GetCartTestCase()
	{
//		
	}
	
	@Test
public void getMaxId(){
	
		Integer l = cartDAO.getMaxId();
	System.out.println(l);
	
}


//@Test
public void tatalamount(){
	
	Long l = cartDAO.get_TotalAmount("rutu956177@gmail.com");
System.out.println(l);

}


	//@Test
	public void getListCart()
	{
	//	Assert.assertEquals("ListCart", 1, cartDAO.list(""rutu956177@gmail.com""));
		Cart cart= (Cart) cartDAO.list("rutu956177@gmail.com");
		System.out.println(cart.getPrice());
	}
	
	
}