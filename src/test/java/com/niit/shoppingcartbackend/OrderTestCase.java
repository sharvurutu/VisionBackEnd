/*package com.niit.shoppingcartbackend;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;


public class OrderTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Order order;

	@Autowired
	static OrderDAO orderDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("backend");
		context.refresh();

		orderDAO = (OrderDAO) context.getBean("orderDAO");
		order = (Order) context.getBean("order");

		System.out.println("this objects are created");

	}

	@Test
	public void createOrderTestCase() {
		order.setId("O_1");
		order.setTotal("5000");
		order.setCart_id("CART_1");
		order.setB_id("BL_2");
		order.setSh_id("SH_3");

		Boolean status = orderDAO.save(order);

		Assert.assertEquals("create Order Test Case", true, status);

	}

	@Test
	public void deleteOrderTestCase() {

		order.setId("O_1");

		Boolean status = orderDAO.delete(order);

		Assert.assertEquals("Delete Order Test Case", true, status);
	}

	@Test
	public void updateOrderTestCase() {
		order.setId("O_1");
		order.setTotal("7000");
		order.setCart_id("CART_1");
		order.setB_id("BL_2");
		order.setSh_id("SH_3");
		Boolean status = orderDAO.update(order);

		Assert.assertEquals("Update Order Test Case", true, status);
	}

	@Test
	public void getOrderTestCase() {

		Assert.assertEquals("get Order Test Case", null, orderDAO.get("abcd"));
	}

	@Test
	public void getAllOrderTestCase() {

		Assert.assertEquals("get Order Test Case", 4, orderDAO.list().size());
	}

}
*/