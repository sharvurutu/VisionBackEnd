package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Expectations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOIMPL implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {

		try {

			if (get(category.getId()) != null) {
				return false;
			}

			sessionFactory.getCurrentSession().save(category);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(Category category) {

		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			System.out.println(e);

			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			System.out.println(e);

			return false;
		}

	}

	@Transactional
	public Category get(String id) {

		return (Category) sessionFactory.getCurrentSession().get(Category.class,id);
	}

	@Transactional
	public List<Category> list() {
		String hql = "FROM Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
