package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	private static Logger log = LoggerFactory.getLogger("CartDAOImpl.class");
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl() {

	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(MyCart mycart) {
		log.debug("Starting of the method save");
		myCart.setId(getMaxId());
		sessionFactory.getCurrentSession().save(cart);
		return true;
	}catch(

	HibernateException e)
	{

		e.printStackTrace();
		return false;
	}
	}

	@Transactional

	public void update(MyCart mycart) {
		log.debug("Starting of the method update");
		sessionFactory.getCurrentSession().update(myCart);
		log.debug("Ending of the method update");

	}

	@Transactional

	public boolean delete(Cart cart) {
		try {

			/*
			 * if (get(cart.getId()) == null) { return false; }
			 */
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional

	public Cart get(String id) {
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);

	}

	@Transactional
	public List<MyCart> list() {
		String hql = "from cart";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
