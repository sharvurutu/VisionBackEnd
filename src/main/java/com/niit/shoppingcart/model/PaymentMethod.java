package com.niit.shoppingcart.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PaymentMethod implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String paymentmethod;



@Override
public String toString() {
	return "PaymentMethod [" + paymentmethod + "]";
}

public String getPaymentmethod() {
	return paymentmethod;
}

public void setPaymentmethod(String paymentmethod) {
	this.paymentmethod = paymentmethod;
}

	
}
