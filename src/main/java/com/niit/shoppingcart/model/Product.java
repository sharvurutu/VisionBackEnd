package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "product")
@Component
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID")
	private String id;
	
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Column(name = "PRICE")
	private int price;
	
	@NotNull
	@Column(name = "STOCK")
	private int stock;
	
	@NotNull
	@Column(name = "C_ID")
	private String c_id;
	
	@NotNull
	@Column(name = "S_ID")
	private String s_id;
	
	@ManyToOne
	@JoinColumn(name="category_id",updatable=false,insertable=false,nullable=false)
	private Category category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

}
