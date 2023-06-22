package com.onerivet.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.pojo.User;
import com.onerivet.repo.UserRepo;

@Service
public class UserServicesImpl implements UserServices {

	

	@Autowired
	private UserRepo userRepo;

	@Override
	public User add(User user) {
		userRepo.save(user);
		
		return user;
	}

	

}
