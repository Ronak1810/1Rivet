package com.onerivet.services;

import java.util.List;

import com.onerivet.entity.User;

public interface UserServices {

	String addUser(User user);

	List<User> getAll();

	User getById(int id);
		

}
