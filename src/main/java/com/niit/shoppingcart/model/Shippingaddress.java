package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


import org.springframework.stereotype.Component;

//@Entity
//@Table(name="ShippingAddress")

@Component
public class ShippingAddress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String address_line1;
	
	private String address_line2;
	
	private String state;
	
	private String city;
	
	private String pincode;
	
	
	
	
	@Override
	public String toString() {
		return "ShippingAddress [" + address_line1 + "," + address_line2 + ","	+ state + "," + city + "," + pincode + "]";
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	

}
