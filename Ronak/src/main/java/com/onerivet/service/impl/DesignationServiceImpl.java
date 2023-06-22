package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.payload.DesignationDto;
import com.onerivet.repository.DesignationRepo;
import com.onerivet.service.DesignationServices;

@Service
public class DesignationServiceImpl implements DesignationServices {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DesignationRepo designationRepo;

	@Override
	public List<DesignationDto> getDesignations() {
		return designationRepo.findAll().stream().map((designation) -> this. modelMapper.map(designation, DesignationDto.class))
				.collect(Collectors.toList());
	}

}
