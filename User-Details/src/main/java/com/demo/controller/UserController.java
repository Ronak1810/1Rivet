package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.demo.entity.User;
import com.demo.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userServices.add(user);
		
	}
	
	@GetMapping("/view-all")
	public List<User> viewAll(
//			@RequestParam (value = "pageNumber", defaultValue = "0", required = false)int pageNumber,
//			@RequestParam (value = "pageSize", defaultValue = "2", required = false)int pageSize,
//			@RequestParam (value = "sortBy", defaultValue = "Ronak", required = false)String sortBy
			){
		return userServices.view();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userServices.getUserById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return userServices.detele(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@PathVariable int id, @RequestBody User user) {
		return userServices.update(id,user);
		
	}

}
