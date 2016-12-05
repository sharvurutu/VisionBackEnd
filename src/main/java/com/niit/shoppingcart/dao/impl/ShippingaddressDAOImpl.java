package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ShippingaddressDAO;
import com.niit.shoppingcart.model.Shippingaddress;



@Repository("shippingaddressDAO")
public class ShippingaddressDAOImpl implements ShippingaddressDAO {
	@Autowired
	SessionFactory sessionFactory;

	public ShippingaddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Shippingaddress Shippingaddress) {
		try {

			/* if (get(Shippingaddress.getId()) != null) { return false; } */

			sessionFactory.getCurrentSession().save(Shippingaddress);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Shippingaddress Shippingaddress) {
		try {
			/* if (get(Shippingaddress.getId()) == null) { return false; } */

			sessionFactory.getCurrentSession().update(Shippingaddress);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Shippingaddress Shippingaddress) {
		try {

			/* if (get(Shippingaddress.getId()) == null) { return false; } */

			sessionFactory.getCurrentSession().delete(Shippingaddress);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public ShippingaddressDAO get(String id) {

		return (ShippingaddressDAO) sessionFactory.getCurrentSession().get(Shippingaddress.class, id);

	}

	@Transactional
	public List<ShippingaddressDAO> list() {
		String hql = "from Shippingaddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
