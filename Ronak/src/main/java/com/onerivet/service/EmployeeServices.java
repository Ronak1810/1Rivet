package com.onerivet.service;

import java.util.List;

import com.onerivet.model.entity.Employee;
import com.onerivet.model.payload.EmployeeDto;

public interface EmployeeServices {

	List<EmployeeDto> getAll();

}
