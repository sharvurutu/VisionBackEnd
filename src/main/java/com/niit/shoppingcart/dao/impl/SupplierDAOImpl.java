package com.niit.shoppingcart.dao.impl;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Supplier get(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	@Transactional
	public List<Supplier> list() {
		String hql = "from supplier";// HQL
		// This HQL need to convert into native query language
		// based on hibernate dialect
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	@Transactional
	public Boolean save(Supplier supplier) {
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
	public Boolean update(Supplier supplier) {
		try {
			if (get(supplier.getId()) == null) {
				return false;
			}
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Boolean delete(Supplier supplier) {
		try {

			if (get(supplier.getId()) == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

}
