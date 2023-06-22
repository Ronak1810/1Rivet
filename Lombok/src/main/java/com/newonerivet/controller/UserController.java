package com.newonerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newonerivet.payload.UserDto;
import com.newonerivet.pojo.Users;
import com.newonerivet.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userService;

	@PostMapping("/add")
	public String add(@Valid @RequestBody UserDto userDto) {
		return userService.add(userDto);

	}

	@GetMapping("/viewall")
	public List<UserDto> getAll() {
		return userService.getAll();

	}

	@GetMapping("/{id}")
	public Users getEmpById(@PathVariable int id) {
		return userService.getUserById(id);

	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return userService.delete(id);

	}

	@PutMapping("/update/{id}")
	public String update(@Valid @RequestBody UserDto userDto,@PathVariable Integer id) {
		return userService.update(userDto, id);

	}

	@GetMapping("/get-by-firstname")
	public List<UserDto> getByFname(@RequestParam String firstName) {
		return userService.findByFname(firstName);

	}

	@GetMapping("/get-by-lastname")
	public List<UserDto> getByLname(@RequestParam String lastName) {
		return userService.findByLname(lastName);

	}

	@GetMapping("/get-by-fullname")
	public List<UserDto> findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
		return userService.findByFirstNameAndLastName(firstName, lastName);

	}

	@GetMapping("/get-by-city")
	public List<UserDto> findByCity(@RequestParam String city) {
		return userService.findByCity(city);

	}
	
	@GetMapping("/get-by-email")
	public List<UserDto> findByEmail(@RequestParam String email) {
		return userService.findByEmail(email);
		
	}

}
