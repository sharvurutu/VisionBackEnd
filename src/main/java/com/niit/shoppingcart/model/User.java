package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "User")
public class User {

	public User() {

		System.out.println("User");
	}

	@NotBlank(message = "Please Enter your First Name")
	@Column(name = "name")
	private String fname;

	@NotBlank(message = "Please Enter your Last Name")
	@Column(name = "last_name")
	private String last_name;

	@NotBlank(message = "Please Enter your Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be only numbers")
	@Column(name = "contact")
	private String contact;

	@Id
	private String Id;

	@NotBlank(message = "Please Enter your mail Id")
	@Column(name = "mail")
	private String mail;

	@NotBlank(message = "Password and Confirm Password Does not match")
	@Size(min = 5, max = 10, message = "Password size must be between 5 to 10")
	@Column(name = "password")
	private String password;

	@NotBlank
	@Column(name = "address")
	private String address;

	private String role;

	@Transient
	private String ConfirmPassword;

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String comPassword) {
		ConfirmPassword = comPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getmail() {
		return mail;
	}

	public void setmail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		if (password.equals(ConfirmPassword)) {
			this.password = password;
		} else
			this.password = null;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
