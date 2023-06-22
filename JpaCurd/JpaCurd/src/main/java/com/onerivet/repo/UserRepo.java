package com.onerivet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.pojo.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
