package com.niit.shoppingcart.config;

import java.util.Properties;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.model.Billingaddress;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Shippingaddress;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;



@Configuration
@ComponentScan("shoppingcartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name = "dataSource")

	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		/* dataSource.setUrl("jdbc:h2:~/test"); */
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		/* dataSource.setPassword("SA"); */
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(Category.class);

		sessionBuilder.addAnnotatedClasses(Supplier.class);

		sessionBuilder.addAnnotatedClasses(Product.class);

		sessionBuilder.addAnnotatedClasses(Cart.class);

		sessionBuilder.addAnnotatedClasses(User.class);

		sessionBuilder.addAnnotatedClasses(Order.class);

		sessionBuilder.addAnnotatedClasses(Billingaddress.class);

		sessionBuilder.addAnnotatedClasses(Shippingaddress.class);

		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}