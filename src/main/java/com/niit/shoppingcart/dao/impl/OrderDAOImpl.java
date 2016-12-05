package com.niit.shoppingcart.dao.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;



@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Order order) {
		try {

			if (get(order.getId()) != null) {
				return false;
			}

			sessionFactory.getCurrentSession().save(order);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Order order) {
		try {
			if (get(order.getId()) == null) {
				return false;
			}

			sessionFactory.getCurrentSession().update(order);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Order order) {
		try {

			if (get(order.getId()) == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(order);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Order get(String id) {

		return (Order) sessionFactory.getCurrentSession().get(Order.class, id);

	}

	@Transactional
	public List<Order> list() {
		String hql = "from Order";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
