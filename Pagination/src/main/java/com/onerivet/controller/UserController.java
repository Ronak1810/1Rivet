package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.payload.UserDto;
import com.onerivet.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/add")
	public String add(UserDto userDto) {
		return userServices.addUser(userDto);	
	}
	
	@GetMapping("/view-all")
	public List<UserDto> viewUser() {
		return userServices.viewAllUser();
		
	}

}
