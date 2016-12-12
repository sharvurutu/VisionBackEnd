package com.niit.shoppingcart.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")
public class CartDAOIMPL implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;

	public CartDAOIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean Save(Cart cart) {
		try {
			/*if (get(cart.getId()) != null) {
				return false;
			}*/
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(String Id) {
		Cart cart = new Cart();
		cart.setUser_Id(Id);
		try {			
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart get(Integer Id) {

		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, Id);
	}

	@Transactional
	public List<Cart> list(String Id) {
		String hql="FROM Cart WHERE USER_ID=:user_id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("user_id", Id);
		List<Cart> list = query.list();
		return list;
	}

	public boolean update(Cart cart) {
		return false;
	}

	@Transactional
	public Long get_TotalAmount(String Id) {
		
		String hql="select sum(price) from Cart where USER_ID=:user_id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("user_id", Id);
		Long sum = (Long) query.uniqueResult();
		return sum;
	}
	
	@Transactional
	public Integer getMaxId(){
		
		Integer MaxId=100;
		try{
			String hql="select max(id) from Cart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
MaxId=(Integer) query.uniqueResult();
}
		catch(Exception e)
		{
			MaxId=100;
			e.printStackTrace();
		}

		return (MaxId+1);
	}


	
	@Transactional
	public boolean deleteByCartId(Cart cart) {
		try {			
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
