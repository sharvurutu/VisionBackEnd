package com.niit.shoppingcart.model;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Table(name="PRODUCT")
public class Product {
	
@Id	
private String Id;
	
@Column(name="NAME")
private String name;

@Column(name="PRICE")
private int price;

@Column(name="C_ID")
private String C_Id;

@Column(name="S_ID")
private String S_Id;

@Column(name="STOCK")
private int stock;

@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="C_Id",updatable=false,insertable=false,nullable=false)
private Category category;

@ManyToOne
@JoinColumn(name="S_Id",nullable=false,insertable=false,updatable=false)
private Supplier supplier;

@Transient
private MultipartFile image;

@Transient
private String path ="D:\\DT NIIT\\yamahaonline\\ProductImages";






public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}





public MultipartFile getImage() {
	return image;
}

public void setImage(MultipartFile image) {
	this.image = image;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	this.Id = id;
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

public String getC_Id() {
	return C_Id;
}

public void setC_Id(String c_Id) {
	C_Id = c_Id;
}

public String getS_Id() {
	return S_Id;
}

public void setSupplier_Id(String s_Id) {
	S_Id = s_Id;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}


}
