package com.cybage.model;

import javax.validation.constraints.NotBlank;

public class User 
{
	@NotBlank(message="Email cannot be blank!")
	private String userEmail;
	@NotBlank(message="Password cannot be blank!")
	private String userPassword;
	public User() {
		super();
	}
	public User(@NotBlank(message = "Email cannot be blank!") String userEmail,
			@NotBlank(message = "Password cannot be blank!") String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
	
}
