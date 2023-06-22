package com.newonerivet.services;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newonerivet.exception.ResourceNotFoundException;
import com.newonerivet.payload.UserDto;
import com.newonerivet.pojo.Users;
import com.newonerivet.repo.UserRepo;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String add(UserDto userDto) {
		Users user = userDtoToUser(userDto);
		userRepo.save(user);
		return "User add Successfully...";
	}

	@Override
	public List<UserDto> getAll() {
		return userRepo.findAll().stream().map(getall -> userToUserDto(getall)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> findByFname(String firstName) {
		return userRepo.findByFirstName(firstName).stream().map(this :: userToUserDto).collect(Collectors.toList());	
		
	}

	@Override
	public List<UserDto> findByLname(String lastName) {
		return userRepo.findByLastName(lastName).stream().map(this :: userToUserDto).collect(Collectors.toList());
		
	}

	@Override
	public String delete(int id) {
		Users u = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		if (u == null)
			return "User not found";
		userRepo.delete(u);
		return "Delete Successfully...";
	}

	@Override
	public Users getUserById(int id) {
		return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
	}

	@Override
	public String update(UserDto userDto, Integer id) {
		
		Users u = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		if (u == null) {
			return "User not found";
		}
		
		u.setFirstName(userDto.getFirstName());
		u.setLastName(userDto.getLastName());
		u.setEmail(userDto.getEmail());
		u.setPassword(userDto.getPassword());
		u.setMobileNumber(userDto.getMobileNumber());
		userRepo.save(u);
		return "Update Successfully...";
		
	}

	@Override
	public UserDto userToUserDto(Users user) {
		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
//		UserDto userDto = new UserDto();
		
//		userDto.setId(user.getId());
//		userDto.setFirstName(user.getFirstName());
//		userDto.setLastName(user.getLastName());
//		userDto.setCity(user.getCity());
//		userDto.setPassword(user.getPassword());
//		userDto.setMobileNumber(user.getMobileNumber());
		
		return userDto;
	}

	@Override
	public Users userDtoToUser(UserDto userDto) {
		
		Users user = modelMapper.map(userDto, Users.class);
		
//		Users user = new Users();
		
//		user.setId(userDto.getId());
//		user.setFirstName(userDto.getFirstName());
//		user.setLastName(userDto.getLastName());
//		user.setCity(userDto.getCity());
//		user.setPassword(userDto.getPassword());
//		user.setMobileNumber(userDto.getMobileNumber());
		
		return user;
	}

	@Override
	public List<UserDto> findByFirstNameAndLastName(String firstName, String lastName) {
		
		return userRepo.findByFirstNameAndLastName(firstName,lastName).stream().map(this :: userToUserDto).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> findByCity(String city) {
	
		return userRepo.findByCity(city).stream().map(this :: userToUserDto).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> findByEmail(String email) {
		
		return userRepo.findByEmail(email).stream().map(this :: userToUserDto).collect(Collectors.toList());
		
	}
	
	
}
