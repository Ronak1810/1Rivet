package com.embedade.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.embedade.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByEmail(String email);
	
	
	
}
