package com.demo.services;

import java.util.List;

import com.demo.entity.User;

public interface UserServices {

	public String add(User user);
	
	public List<User> view();

	public User getUserById(int id);

	public String detele(int id);

	public String update(int id, User user);
}
