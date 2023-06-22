package com.onerivet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.dtos.EmployeeDto;
import com.onerivet.services.EmployeeServices;

import jakarta.validation.Valid;


@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;
	
	@GetMapping("/get-all-employees")
	public List<EmployeeDto> getAllEmployee(){
		return employeeServices.getAll();	
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getEmployee(@PathVariable int id) {
		return employeeServices.getEmployee(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployee( @PathVariable int id, @RequestBody@Valid EmployeeDto employeeDto) {
		return employeeServices.update(id, employeeDto);
	}
}
