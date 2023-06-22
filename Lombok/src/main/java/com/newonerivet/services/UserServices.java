package com.newonerivet.services;

import java.util.List;

import org.apache.catalina.User;

import com.newonerivet.payload.UserDto;
import com.newonerivet.pojo.Users;

public interface UserServices {

	String add(UserDto userDto);
	
	List<UserDto> getAll();
	
	List<UserDto> findByFname(String firstName);
	
	List<UserDto> findByLname(String lastName);
	
	List<UserDto> findByFirstNameAndLastName(String firstName,String lastName);
	
	List<UserDto> findByCity(String city);
	
	List<UserDto> findByEmail(String email);
	
	String delete(int id);

	Users getUserById(int id);
	
	String update(UserDto userDto, Integer id);
	
	UserDto userToUserDto(Users user);
	
	Users userDtoToUser(UserDto userDto);
	
}
