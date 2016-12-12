package com.niit.shoppingcart.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Component
@Table(name = "cart")
public class Cart implements Serializable {

	@Id
	private int Id;

	@Column(name = "User_Id")
	private String User_Id;

	@Column(name = "Product_Name")
	private String Product_Name;

	@Column(name = "price")
	private int price;

	@Column(name = "Status")
	private char status;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "Date_added")
	private Date date_added;

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public char getStatus() {
		return status;
	}

public void setStatus(char status) {
		this.status = status;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
