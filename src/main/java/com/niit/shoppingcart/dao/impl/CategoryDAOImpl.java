package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.sun.media.jfxmedia.logging.Logger;



@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	Logger log= LoggerFactory.getLogger(CategoryDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Category> list() {
		logger.debug("calling list");
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>)
		sessionFactory.getCurrentSession()
		.createCriteria(Category.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.debug("calling list");
		return listCategory;
	}

	@Transactional
	public boolean save(Category category) {
		logger.debug("Starting of the method save");
		
		try {

			if (get(category.getId()) != null) {
				return false;
			}

			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Exception occured while saving category");
			Logger.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		Logger.debug("Starting of the method saveOrUpadate");
		try {
				/* * if (get(category.getId()) == null) { return false; }*/
				 
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Exception occured while saveOrUpdate category");
			Logger.error(e.getMessage());
			return false;
		}

	}

	@Transactional
	public boolean delete(Category category) {
		try {
			
			/* * if (get(category.getId()) == null) { return false; } */
			 
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Category get(String id) {
		Logger.debug("calling get");
		String hql = "from category where id=" + " ' "+ id +" ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		logger.debug("hql:" + hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if(listCategory != null && !listCategory.isEmpty())
		{
			return listCategory.get(0);
		}
		logger.debug("End get");
		return null;

	}

	@Transactional
	public Category getByName(String name) {
		String hql = "from Category where name=" + " ' "+name+" ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Category)query.uniqueResult();
	}
}
