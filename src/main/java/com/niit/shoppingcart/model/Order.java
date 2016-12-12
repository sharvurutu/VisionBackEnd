package com.niit.shoppingcart.model;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

//@Entity
//@Table(name="UserOrder")

@Component
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	//@Id
	private String Id;
	
	private String sa;

	private String ba;
	
	private String pm;
	
	//@Column(name="Product_Name")
	private String Product_Name;
	
	//@Column(name="Product_price")
	private int Product_Price;
	
/*	@Column(name="User_Id")
*/	private String User_Id;
	
	

	//@Column(name = "Pay_Method")
	
    @Autowired
	private PaymentMethod paymentMethod;
	
	//
	//@Column(name="ShippingAddress")
	@Autowired
	private ShippingAddress shippingAddress;
	
	//@Column(name="BillingAddress")
	@Autowired
	private BillingAddress billingAddress;

	
	public Order()
	{
		System.out.println("UserOrder is created");
		this.Id= "Yamaha_Online" + UUID.randomUUID();
	}
	
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	
	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public int getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(int product_Price) {
		Product_Price = product_Price;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}


	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getBa() {
		return ba;
	}

	public void setBa(String ba) {
		this.ba = ba;
	}


	public String getPm() {
		return pm;
	}


	public void setPm(String pm) {
		this.pm = pm;
	}


	
	
	
}
