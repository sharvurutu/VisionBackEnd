package com.niit.shoppingcart.dao.impl;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.model.ShippingAddress;

@Repository("shippingaddressDAO")
public class ShippingAddressDAOIMPL implements ShippingAddressDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ShippingAddressDAOIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public boolean save(ShippingAddress shippingaddress) {
		try {
			/*if (get(shippingaddress.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().save(shippingaddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(ShippingAddress shippingaddress) {
		try {
			/*if (get(shippingaddress.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().delete(shippingaddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public ShippingAddress get(String Id) {
		return (ShippingAddress) sessionFactory.getCurrentSession().get(ShippingAddress.class, Id);
	}

}
