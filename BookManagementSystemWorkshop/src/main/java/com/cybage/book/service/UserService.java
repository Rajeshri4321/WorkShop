package com.cybage.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.book.model.User;

@Service
public class UserService {
	List<User> userList = new ArrayList<>();

	public UserService() {
		userList.add(new User("admin", "admin@123"));
	}

	public User getUser(String username) {
		User user = null;
		for (int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getUsername().equals(username))
				return user;
		}
		return user;
	}

	public boolean ifUserExist(String username) {
		if (getUser(username) == null)
			return false;
		return true;
	}

	public User login(String username, String password) {
		if (!ifUserExist(username)) {
			User user = getUser(username);
			if (password.equals(user.getPassword()))
				return user;
		}
		return null;
	}
}
