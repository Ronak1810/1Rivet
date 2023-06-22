package com.newonerivet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.newonerivet.pojo.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{
	
	@Query(value="SELECT * FROM details WHERE first_name=?",nativeQuery = true)
	public List<Users> findByFirstName(String firstName);
	
	public List<Users> findByLastName(String lastName);
	
	public List<Users> findByFirstNameAndLastName(String firstName ,String lastName);
	
	public List<Users> findByCity(String city);
	
	public List<Users> findByEmail(String email);

}
