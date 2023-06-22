package com.onerivet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.onerivet.model.entity.User;
import com.onerivet.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userInfo = userRepository.findByUserName(username).get();
		System.out.println("Service");
		return new UserInfoUserDetails(userInfo);

	}

}
