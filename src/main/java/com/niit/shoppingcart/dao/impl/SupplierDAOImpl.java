package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOIMPL implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {

		try {
			if (get(supplier.getId()) != null) {
				return false;

			}
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(Supplier supplier) {

		try {
			/*if (get(supplier.getId()) == null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}

		catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Transactional
	public boolean udpate(Supplier supplier) {

		try {
			/*if (get(supplier.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}

		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public Supplier get(String Id) {
	return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,Id);
	}

@Transactional
	public List<Supplier> list() {
String hql = "From Supplier";
Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}

}
