package com.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.Employee;
import com.security.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmpService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee add(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> viewAll(Employee emp) {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public String deleteEmpById(int id) {
		Employee e = employeeRepository.findById(id).get();
		if(e == null)
			return "Employee not found !!";
		else
			employeeRepository.delete(e);
			return "Emplpyee Deleted Successfully....";
	}

	@Override
	public String update(Employee emp, int id) {
		Employee e = employeeRepository.findById(id).get();
		if(e == null)
			return "Employee not found !!";
		else
			e.setEmail(emp.getEmail());
			e.setName(emp.getName());
			e.setPassword(emp.getPassword());
			employeeRepository.save(e);
			return "Updated Successfully....!!";
	}

}
