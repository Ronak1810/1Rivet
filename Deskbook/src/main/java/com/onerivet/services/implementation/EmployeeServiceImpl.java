package com.onerivet.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.exception.ResourceNotFoundException;
import com.onerivet.model.dtos.EmployeeDto;
import com.onerivet.model.entity.Employee;
import com.onerivet.reposiretories.EmployeeRepository;
import com.onerivet.services.EmployeeServices;

@Service
public class EmployeeServiceImpl implements EmployeeServices{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return employee;
	}
	
	private EmployeeDto employeeToEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}
	
	@Override
	public List<EmployeeDto> getAll() {
		return employeeRepository.findAll().stream().map(all -> modelMapper.map(all, EmployeeDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public EmployeeDto getEmployee(int id) {
		return employeeToEmployeeDto(employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found..."))); 
	}

	@Override
	public String update(int id, EmployeeDto employeeDto) {
		Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found..."));
		if(emp == null)
			return "Employee Not found.";
		else 
			employeeDto.setId(emp.getId());
			employeeRepository.save(employeeDtoToEmployee(employeeDto));
		return "Employee Updated Successfully...";
	}

}
