package com.onerivet.services;

import java.util.List;

import com.onerivet.model.dtos.EmployeeDto;

public interface EmployeeServices {

	List<EmployeeDto> getAll();

	EmployeeDto getEmployee(int id);

	String update(int id, EmployeeDto employeeDto);

}
