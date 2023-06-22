package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.entity.ModeOfWork;
import com.onerivet.model.payload.ModeOfWorkDto;
import com.onerivet.repository.ModeOfWorkRepo;
import com.onerivet.service.ModeOfWorkServices;

@Service
public class ModeOfWorkServiceImpl implements ModeOfWorkServices {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ModeOfWorkRepo modeOfWorkRepo;
	
	@Override
	public List<ModeOfWorkDto> getAllModeOfWorks() {
		return modeOfWorkRepo.findAll().stream().map((modeOfWork) -> modelMapper.map(modeOfWork, ModeOfWorkDto.class)).collect(Collectors.toList());
	}

}
