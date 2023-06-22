package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.User;
import com.demo.repository.UserRepository;
import com.demo.services.UserServices;

@SpringBootTest
class DemoApplicationTests {
	
	private User user;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void getUserTest() {
		
	}

}
