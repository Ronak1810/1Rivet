package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.pojo.User;
import com.onerivet.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return userServices.add(user);

	}
//	
//	@GetMapping("/viewall")
//	public List<User> getAll() {
//		return userServices.getAll();
		
	
}
