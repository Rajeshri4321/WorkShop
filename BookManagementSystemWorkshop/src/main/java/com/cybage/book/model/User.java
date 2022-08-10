package com.cybage.book.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class User {
	@NotBlank(message = "Username can't be null")
	private String username;
	@NotBlank(message = "password can't be null")
	private String password;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

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
