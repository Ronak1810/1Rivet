package com.demo.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import com.demo.model.User;
import com.demo.repository.UserRepository;

import lombok.Builder;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;
	
	
	private UserServiceImpl userServiceImpl;
	private User user;
	private List<User> u;
	User getSingleUser;
	
	@BeforeEach
	void setUp() throws Exception{
	 userServiceImpl=new UserServiceImpl(userRepository);
		user = User.builder()
				.id(0)
				.email("ronak@email.com")
				.name("Ronako")
				.build();
//		user = User.builder()
//				.id(1)
//				.email("preet@email.com")
//				.name("Preet")
//				.build();
		
//		u = new ArrayList<>();
//		u.add(user);
//		u.add(User.builder()
//				.id(1)
//				.email("ronak@email.com")
//				.name("Ronako")
//				.build());
//		u.add(User.builder()
//				.id(0)
//				.email("ronak@email.com")
//				.name("Ronako")
//				.build());
//		u.add(User.builder()
//				.id(1)
//				.email("gracy@email.com")
//				.name("Gracy")
//				.build());
		
	}
	
	@Test
	void testAdd() {
		mock(User.class);
		mock(UserServiceImpl.class);
		when(this.userRepository.save(user)).thenReturn(user);
		User savedUser = userServiceImpl.add(user);
		assertEquals(user, savedUser);
	}

	@Test
	void testGetAll() {
//		List<User> users = new ArrayList();
//        users.add(new User(1, "Ronak", "ronak@gmail.com"));
//        users.add(new User(2, "Gracy", "gracy@gmail.com"));
		mock(User.class);
		mock(UserServiceImpl.class);
		when(this.userRepository.findAll()).thenReturn(u);
		List<User> getAllUser = userServiceImpl.getAll();
		assertEquals(u, getAllUser);
	}

	@Test
	void testGetUser() {
		mock(User.class);
		mock(UserServiceImpl.class);
		System.out.println(getSingleUser);
		when(this.userRepository.findById(1)).thenReturn(Optional.of(user));
		getSingleUser = this.userServiceImpl.getUser(0);
		System.out.println(getSingleUser);
		assertEquals(user, getSingleUser);
	}

	@Test
	void testDelete() {
		mock(User.class);
		mock(UserServiceImpl.class);
		when(this.userServiceImpl.delete(1)).thenReturn("User Not Found");
		String deleteUser = this.userServiceImpl.delete(1);
		assertEquals("User Not Found...", deleteUser);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	

}
