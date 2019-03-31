package com.examples.spring.web.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@NotNull(message="User Name cann't be null")
	private String userName;
	@NotNull(message="User Name cann't be null")
	@Size(min = 8, message="password should contain atleast 8 characters")
	private String password;
	
	public User() {
		
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
