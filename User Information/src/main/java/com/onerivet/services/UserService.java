package com.onerivet.services;

import java.util.List;

import com.onerivet.model.payload.UserDto;

public interface UserService {

	String addUser(UserDto userDto);
	
	List<UserDto> getAllUser();
	
	UserDto getUserById(int id);
	
	String update(UserDto userDto, int id);
	
	String delete(int id);

}
