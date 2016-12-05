package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.BillingaddressDAO;
import com.niit.shoppingcart.model.Billingaddress;



@Repository("billingaddressDAO")
public class BillingaddressDAOImpl implements BillingaddressDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BillingaddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Billingaddress Billingaddress) {
		try {

			/* if (get(Billingaddress.getId()) != null) { return false; } */

			sessionFactory.getCurrentSession().save(Billingaddress);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Billingaddress Billingaddress) {
		try {
			/* if (get(Billingaddress.getId()) == null) { return false; } */

			sessionFactory.getCurrentSession().update(Billingaddress);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Billingaddress Billingaddress) {
		try {

			/* if (get(Billingaddress.getId()) == null) { return false; } */

			sessionFactory.getCurrentSession().delete(Billingaddress);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public BillingaddressDAO get(String id) {

		return (BillingaddressDAO) sessionFactory.getCurrentSession().get(Billingaddress.class, id);

	}

	@Transactional
	public List<BillingaddressDAO> list() {
		String hql = "from Billingaddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
