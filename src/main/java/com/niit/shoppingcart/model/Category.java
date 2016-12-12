package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.Fetch;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Category")
public class Category {
	
	@Id
	private String Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="category",fetch =FetchType.EAGER)
	private Set<Product> products;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


}
