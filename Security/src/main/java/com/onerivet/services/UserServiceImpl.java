package com.onerivet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.entity.User;
import com.onerivet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String addUser(User user) {
		userRepository.save(user);
		return "User Saved...";
	}

	@Override
	public List<User> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User getById(int id) {
		return userRepository.findById(id).get();
	}

}
