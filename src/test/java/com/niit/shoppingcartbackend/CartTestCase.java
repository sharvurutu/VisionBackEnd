/*package com.niit.shoppingcartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;


public class CartTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Cart cart;

	@Autowired
	static CartDAO cartDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		cartDAO = (CartDAO) context.getBean("cartDAO");
		cart = (Cart) context.getBean("cart");

		System.out.println("this objects are created");

	}

	@Test
	public void createcartTestCase() {
		cart.setId("CART_2");
		cart.setP_id("PRO_2");

		cart.setQuantity(3);
		cart.setPrice(3900);

		Boolean status = cartDAO.save(cart);

		Assert.assertEquals("create cart Test Case", true, status);

	}

	@Test
	public void deletecartTestCase() {

		cart.setId("CART_2");
		Boolean status = cartDAO.delete(cart);

		Assert.assertEquals("Delete cart Test Case", true, status);
	}

	@Test
	public void updatecartTestCase() {
		cart.setId("CART_1");
		cart.setPrice(45678);
		cart.setP_id("PRO_2");

		cart.setQuantity(3);
		Boolean status = cartDAO.update(cart);

		Assert.assertEquals("Update Cart Test Case", true, status);
	}

	@Test
	public void getCartTestCase() {

		Assert.assertEquals("get Cart Test Case", null, cartDAO.get("abcd"));
	}

	@Test
	public void getAllCartTestCase() {

		Assert.assertEquals("get Cart Test Case", 1, cartDAO.list().size());
	}

}
*/