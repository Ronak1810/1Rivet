package com.embedade.services;

import java.util.List;

import com.embedade.entity.Student;
import com.embedade.payload.StudentDto;

public interface StudentServices {

	String add(StudentDto studentDto);
	
	List<StudentDto> getAll();
	
	String delete(int id);

	Student getStudentById(int id);
	
	String update(StudentDto userDto, Integer id);

	Student findByEmail(String email);
	
}
