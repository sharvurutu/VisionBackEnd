package com.niit.shoppingcart.dao.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;



@Repository("userDAO")
public class UserDAOIMPL implements UserDAO{

	@Autowired SessionFactory sessionFactory;
	
	public UserDAOIMPL(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(User user) {
		
		try
		{
			/*if(get(user.getUserId())!=null)
					return false;
		*/
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		
		catch(Exception e)
		{
		e.printStackTrace();	
				return false;
	}
	}
	
		
	public boolean delete(User user) {
		try
		{
		/*if(get(user.getUserId())!=null)
		{
			return false;
		}*/
		sessionFactory.getCurrentSession().delete(user);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return  false;
		}
		}
	
	public boolean update(User user) {
		try
		{
		/*	if(get(user.getUserId())!=null)
			{
				return false;
			}*/
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			
		e.printStackTrace();
		return false;
	}
	}
	
	@Transactional
	public User get(String UserId) {
return (User) sessionFactory.getCurrentSession().get(User.class, UserId) ;
		
	}

	
	public List<User> list() {
		String hql = "FROM User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

@Transactional
	public User IsValidUser(String mail, String password) {
	try{
		String hql = "FROM User o where o.mail= :mail and o.password= :password";
		Query st  = sessionFactory.getCurrentSession().createQuery(hql);
		st.setString("mail", mail);
		st.setString("password", password);
	return (User) st.uniqueResult();
	
	}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
