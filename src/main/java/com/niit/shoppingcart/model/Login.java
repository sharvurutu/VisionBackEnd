package com.niit.shoppingcart.model;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Component
public class Login {	
	@NotNull
	@Size(min=6,max=30,message="Username Should be Between 6 to 30")
	private String username;
	
	@NotNull
	@Size(min=4,max=30,message="Password Should be Between 6 to 10")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}


/*package com.niit.shoppingcart.model;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Component
public class Login {	
	@NotNull
	@Size(min=6,max=30,message="Userusername Should be Between 4 to 10")
	private String username;
	
	@NotNull
	@Size(min=4,max=30,message="passwordword Should be Between 4 to 10")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
*/