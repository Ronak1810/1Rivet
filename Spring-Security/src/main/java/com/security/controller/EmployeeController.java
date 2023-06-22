package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Employee;
import com.security.services.EmpService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/add")
	public Employee addEmp(@RequestBody Employee emp) {
		return empService.add(emp);
		
	}
	
	@GetMapping("/viewall")
	public List<Employee> viewAll(Employee emp){
		return empService.viewAll(emp);
		
	}
	
	@GetMapping("/get-emp-by-id")
	public Employee getEmpById(@PathVariable int id) {
		return empService.getEmpById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		return empService.deleteEmpById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateEmp(@PathVariable int id, @RequestBody Employee emp) {
		return empService.update(emp, id);
	}

}
