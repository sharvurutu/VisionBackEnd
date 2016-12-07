package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "shippingaddress")
@Component
public class Shippingaddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID")
	private String id;

	@NotNull
	@Column(name = "h_no")
	private String h_no;

	@NotNull
	@Column(name = "street")
	private String street;

	@NotNull
	@Column(name = "city")
	private String city;

	@NotNull
	@Column(name = "country")
	private String country;

	@NotNull
	@Column(name = "pin")
	private String pin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getH_no() {
		return h_no;
	}

	public void setH_no(String h_no) {
		this.h_no = h_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
