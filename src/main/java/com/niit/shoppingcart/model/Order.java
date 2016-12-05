package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "order1")
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String u_id;
	private Cart cart;
	private Billingaddress b_id;
	private Shippingaddress sh_id;
	private long total;
	private String paymentMethod;
	
	public Order()
	{
		this.id= "SHP_CRT_ORD_" + UUID.randomUUID();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*public String getCart() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getSh_id() {
		return sh_id;
	}
	public void setSh_id(String sh_id) {
		this.sh_id = sh_id;
	}*/
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	

}
