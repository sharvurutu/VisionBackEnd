package com.niit.shoppingcart.dao.impl;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserOrderDAO;
import com.niit.shoppingcart.model.Order;


@Repository("userorderDAO")
public class UserOrderDAOIMPL implements UserOrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserOrderDAOIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Order userorder) {
		try {
			if (get(userorder.getId()) != null) {
				return false;
			}
			sessionFactory.getCurrentSession().save(userorder);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public boolean delete(Order userorder) {
		try {
			if (get(userorder.getId()) != null) {
				return false;
			}
			sessionFactory.getCurrentSession().delete(userorder);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Order get(String Id) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, Id);
	}

}
