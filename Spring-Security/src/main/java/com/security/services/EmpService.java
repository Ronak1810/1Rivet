package com.security.services;

import java.util.List;

import com.security.entity.Employee;

public interface EmpService {
	
	Employee add(Employee emp);
	
	List<Employee> viewAll(Employee emp);
	
	Employee getEmpById (int id);
	
	String deleteEmpById(int id);
	
	String update(Employee emp, int id);
}
