package com.onerivet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String username);
}
