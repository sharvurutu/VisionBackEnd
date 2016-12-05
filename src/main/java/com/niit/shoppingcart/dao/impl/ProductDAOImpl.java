package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.sun.media.jfxmedia.logging.Logger;



@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Product product) {
		try {
			
			/* * if (get(product.getId()) != null) { return false; }*/
			 
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional

	public boolean update(Product product) {
		try {
			if (get(product.getId()) == null) {
				return false;
			}
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional

	public boolean delete(Product product) {
		try {
			
			/* * if (get(product.getId()) == null) { return false; } */
			 

			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional

	public Product get(String id) {
		Logger.debug("calling get");
		String hql = "from product where id=" + " ' "+ id +" ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		logger.debug("hql:" + hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if(listProduct != null && !listProduct.isEmpty())
		{
			return listProduct.get(0);
		}
		logger.debug("End get");
		return null;

	}

	

	@Transactional
	public List<Product> getSimilarProducts(String searchText) {
		String hql = "from product where name like %"+searchText + "%";
		Query query = sessionFactory.getCurrentSession().createCriteria(hql);
		return query.list();

	}

}
