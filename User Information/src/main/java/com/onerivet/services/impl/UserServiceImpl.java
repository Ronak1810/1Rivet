package com.onerivet.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onerivet.exception.ResourceNotFoundException;
import com.onerivet.model.entity.User;
import com.onerivet.model.payload.UserDto;
import com.onerivet.repository.UserRepository;
import com.onerivet.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addUser(UserDto userDto) {
		User user = userDtoToUser(userDto);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return "User added successfully";
	}

	@Override
	public List<UserDto> getAllUser() {
		return userRepository.findAll().stream().map(getUser -> modelMapper.map(getUser, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(int id) {
		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with this id is not found"));
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public String update(UserDto userDto, int id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with this id is not found"));
		if (user == null) {
			return "Pleasr enter valid id.";
		}
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
		return "User updated successfully...";
	}

	@Override
	public String delete(int id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with this id is not found"));
		if (user == null) {
			return "Pleasr enter valid id.";
		}
		userRepository.deleteById(id);
		return "User deleted successfully...";
	}
	
	
	private UserDto userToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	private User userDtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
	

}
