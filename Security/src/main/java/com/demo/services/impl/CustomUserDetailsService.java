package com.demo.services.impl;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		CustomUserDetails customUserDetails= null;
		if(user != null) {
			customUserDetails = new CustomUserDetails();
			customUserDetails.setUser(user);
		}
		else {
			throw new UsernameNotFoundException("User Not exist with name : "+ username);
		}
		return customUserDetails;
	}

}
