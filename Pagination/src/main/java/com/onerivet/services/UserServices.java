package com.onerivet.services;

import java.util.List;

import com.onerivet.payload.UserDto;

public interface UserServices {

	String addUser(UserDto userDto);

	List<UserDto> viewAllUser();

}
