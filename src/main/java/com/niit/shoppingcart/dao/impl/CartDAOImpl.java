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
import com.niit.shoppingcart.model.MyCart;


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
	public void save(MyCart myCart) {
		log.debug("Starting of the method save");
		myCart.setId(getMaxId());
		sessionFactory.getCurrentSession().save(myCart);
		log.debug("Ending of the method save");
	}

	@Transactional

	public void update(MyCart myCart) {
		log.debug("Starting of the method update");
		sessionFactory.getCurrentSession().update(myCart);
		log.debug("Ending of the method update");
	}

	@Transactional

	public String delete(String id) {
		log.debug("Starting of the method delete");
		MyCart myCart = new MyCart();
		myCart.setUserID(id);
		try
		{
			sessionFactory.getCurrentSession().delete(myCart);

		} catch (HibernateException e) {

			e.printStackTrace();
			return e.getMessage();
		}

	}

	@Transactional
	public Long getTotalAmount(String id)
	{
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price) from MyCart where userID="+ " ' "+id+" ' "+" and status ="+"'N'";
		log.debug("hql"+hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
		log.debug("sum=" +sum);
		
		log.debug("Ending of the method getTotalAmount");
		return sum;
	}

	@Transactional
	private long getMaxId()
	{
		log.debug("Starting of the method getMaxId");
		long maxID = 100L;
		try
		{
			String hql = "select max(id) from MyCart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			maxID= (Long) query.uniqueResult();
		}
		catch(HibernateException e)
		{
			log.debug("It seems this is first record. setting initial id is 100:");
			maxID = 100L;
			e.printStackTrace();
		}
		log.debug("Max id:"+maxID);
		
		log.debug("Ending of the method getMaxId");
		return maxID;
	}
	
	@Transactional
	public List<MyCart> list(String id) {
		log.debug("Starting of the method list");
		String hql = "from MyCart where userID=" + " ' " + id + " ' and status =" + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MyCart> list = (List<MyCart>) query.list();
		log.debug("Ending of the method list");
		return list;
	}

}
