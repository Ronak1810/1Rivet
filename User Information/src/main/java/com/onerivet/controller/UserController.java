package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.payload.AuthRequest;
import com.onerivet.model.payload.UserDto;
import com.onerivet.services.JwtService;
import com.onerivet.services.UserService;

@RestController
@RequestMapping("/api/information")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/add")
	public String add(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}
	
	@GetMapping("/get-user")
	public List<UserDto> getUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/get-user/{id}")
	public UserDto getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody UserDto userDto, @PathVariable int id) {
		return userService.update(userDto, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.delete(id);
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		System.out.println("2nd");
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		
		System.out.println("1at");
		System.out.println(authentication.isAuthenticated());
		if(authentication.isAuthenticated()) {
			System.out.println("ronak");
			System.out.println(jwtService.generateToken(authRequest.getUserName()));
			System.out.println("abhi");
			return jwtService.generateToken(authRequest.getUserName());
		}
		else {
			throw new UsernameNotFoundException("Invalid user Request");
		}
//		return jwtService.generateToken(authRequest.getEmail());
	}

}
