package com.niit.shoppingcart.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Component
public class MyCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID")
	private long id;

	@NotNull
	@Column(name = "userID")
	private String userID;

	@NotNull
	@Column(name = "PRODUCT_NAME")
	private String productName;

	@NotNull
	@Column(name = "PRICE")
	private int price;

	@NotNull
	@Column(name = "QUANTITY")
	private int quantity;

	@Transient
	private int total;

	private char status;

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
