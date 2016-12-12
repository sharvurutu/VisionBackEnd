package com.niit.shoppingcart.dao.impl;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ContactusDAO;
import com.niit.shoppingcart.model.Contactus;

@Repository("contactusDAO")
public class ContactusDAOIMPL implements ContactusDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
		public boolean save(Contactus contactus) {
		try{
		sessionFactory.getCurrentSession().save(contactus);
		return true;
	} 
		catch (Exception e) {
		e.printStackTrace();
		return false;
	}			
		}	
	

	
}
