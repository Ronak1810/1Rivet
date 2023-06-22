package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.payload.WorkingDayDto;
import com.onerivet.repository.WorkingDayRepo;
import com.onerivet.service.WorkingDayServices;

@Service
public class WorkingDayServiceImpl implements WorkingDayServices{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WorkingDayRepo workingDayRepo;

	@Override
	public List<WorkingDayDto> getAllWorkingDays() {
		return workingDayRepo.findAll().stream().map((workingDay) -> modelMapper.map(workingDay, WorkingDayDto.class)).collect(Collectors.toList());
	}	

}
