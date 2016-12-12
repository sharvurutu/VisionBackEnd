package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO {
	
	@Autowired
SessionFactory sessionFactory;
	
	public ProductDAOIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public boolean save(Product product) {
		try {
			/*if (get(product.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(Product product) {
		try {
			/*if (get(product.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
@Transactional
	public boolean update(Product product) {
		try {
			/*if (get(product.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().update(product);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public Product get(String Id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, Id);

	}

@Transactional
public Product getByName(String name) {
	return (Product) sessionFactory.getCurrentSession().get(Product.class, name);

}


@Transactional
	public List<Product> list() {
		String hql = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
