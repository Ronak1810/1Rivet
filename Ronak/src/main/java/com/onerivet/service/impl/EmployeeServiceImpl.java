package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.payload.EmployeeDto;
import com.onerivet.repository.EmployeeRepo;
import com.onerivet.service.EmployeeServices;

@Service
public class EmployeeServiceImpl implements EmployeeServices{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<EmployeeDto> getAll() {
		return employeeRepo.findAll().stream().map((employee) -> this.modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
	}
	
	

}
