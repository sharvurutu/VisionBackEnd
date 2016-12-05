package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
			log.info("The connection is established properly..");
		} catch (Exception e) {
			log.error("Not able to prepare connection. Please check application" + "context java file");
			e.printStackTrace();
		}
	}

	@Transactional

	public boolean saveOrUpdate(User user) {
		log.debug("Starting of the method : saveOrUpadate");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		log.debug("Ending of the method : saveOrUpadate");

	}

	@Transactional

	public boolean delete(String id) {
		log.debug("Starting of the method : delete");
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);

	}

	@Transactional

	public User get(String id) {
		log.debug("Starting of the method: get ");
		String hql = "from User where id=" + " ' " + id + " ' ";
		return getUserDetails(hql);

	}

	@Transactional

	public List<User> list() {
		log.debug("Starting of the method : list");
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.debug("Ending of the method : list");
		return list;

	}

	public User isValidUser(String userID, String password) {

		log.debug("Starting of the methos : isValidUser");
		log.info("The user id:" + id);
		String hql = "from User where id=" + " ' " + id + " ' " + " and " + "password =" + " ' ";
		log.info(" The query is :" + hql);
		return getUserDetails(hql);
	}

}
