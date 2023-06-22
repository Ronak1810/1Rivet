package com.embedade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embedade.entity.Student;
import com.embedade.payload.StudentDto;
import com.embedade.services.StudentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class StudentController {
	
	@Autowired
	private StudentServices studentServices;
	
	@PostMapping("/add")
	public String add(@Valid @RequestBody StudentDto studentDto) {
		return studentServices.add(studentDto);		
	}
	
	@GetMapping("/viewall")
	public List<StudentDto> getAll(){
		return studentServices.getAll();	
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id){
		return studentServices.getStudentById(id);	
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentServices.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable int id) {
		return studentServices.update(studentDto, id);
	}
	
	@GetMapping("/get-by-email")
	public Student findByEmail(@RequestParam String email) {
		return studentServices.findByEmail(email);
		
	}
}
