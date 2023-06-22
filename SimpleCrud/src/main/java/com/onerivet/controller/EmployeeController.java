package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.entity.Employee;
import com.onerivet.model.payload.EmployeeDto;
import com.onerivet.service.EmployeeServices;

@RestController
@RequestMapping("/api/deskbook/user-profile")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;
	
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployees(){
		return employeeServices.getAll();
	}
}
