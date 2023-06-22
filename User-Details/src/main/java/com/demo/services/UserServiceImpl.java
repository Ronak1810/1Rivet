package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String add(User user) {
		userRepository.save(user);
		return "User Added Successfully....";
	}

	@Override
	public List<User> view(){
//		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by("name"));
//		
//		return userRepository.findAll(pageable).getContent();
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public String detele(int id) {
		User u = userRepository.findById(id).get();
		if(u == null)
			return "Please Enter Valid Id..";
		else
			userRepository.deleteById(id);
			return "Delete Successfully..";
	}

	@Override
	public String update(int id, User user) {
		User u = userRepository.findById(id).get();
		if(u == null)
			return "Please Enter Valid Id..";
		else
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			userRepository.save(u);
			return "Update Successfully..";
	}

}
