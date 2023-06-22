package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.User;
import com.onerivet.services.UserServices;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userServices.addUser(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/view-all")
	public List<User> getAll() {
		return userServices.getAll();
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/view-by-id/{id}")
	public User getById(@PathVariable int id) {
		return userServices.getById(id);
	}

	
}
