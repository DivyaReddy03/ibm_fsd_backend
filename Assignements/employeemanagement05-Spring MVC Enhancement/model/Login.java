package com.examples.spring.web.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	@NotNull(message="userName cannot be null")
	private String userName;
	@NotNull
	@Size(min=8, message="password cannot be null")
	private String password;
	
	public Login()
	{
		
	}
	
	public Login(String userName, String password)
	{
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
