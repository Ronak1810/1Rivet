package com.onerivet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.onerivet.entity.User;
import com.onerivet.payload.UserDto;
import com.onerivet.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addUser(UserDto userDto) {
		User user = userToUserDto(userDto);
		userRepository.save(user);
		return "User Added Successfully...";
	}

	private User userToUserDto(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user ;
	}
	
	private UserDto userDtoToUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	@Override
	public List<UserDto> viewAllUser() {
		return userRepository.findAll().stream().map(this:: userToUserDto).collect(Collectors.toList());
		 
	}
}
