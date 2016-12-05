package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="id")
	private String id;
	
	@NotEmpty(message="please enter your name")
	@Size(min=3, max=35)
	@Column(name="name")
	private String name;
	
	@Min(5)
	@Max(15)
	private String password;
	
	@NotNull
	@Column(name="contact")
	private int contact;
	
	@NotNull
	@Size(min=5, max=35)
	@Column(name="address")
	private String address;
	
	@Pattern(regexp=".+@.+\\..+", message="Wrong email...")
	@Column(name="email")
	@NotEmpty(message="please enter your mail id")
	private String mail;
	
	
	private String role;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
