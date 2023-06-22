package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.services.UserServices;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	@Autowired
	private UserServices userServices;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUser(@RequestBody User user) {		
		return userServices.add(user);
	}
	
	@GetMapping("/greet")
	public String greeting() {
		return " Good Morning";
	}
	
	@GetMapping("/get-all")
	public List<User> getAllUser(){
		return userServices.getAll(); 	
	}
	
	@GetMapping("/get-user/{id}")
	public User getUser(@PathVariable int id) {
		return userServices.getUser(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return userServices.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user) {
		return userServices.update(id, user);
	}

}
