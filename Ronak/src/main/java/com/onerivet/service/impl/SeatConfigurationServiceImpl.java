package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.entity.City;
import com.onerivet.model.entity.ColumnDetails;
import com.onerivet.model.entity.Floor;
import com.onerivet.model.payload.ColumnDetailsDto;
import com.onerivet.model.payload.FloorDto;
import com.onerivet.model.payload.SeatDto;
import com.onerivet.repository.ColumnDetailsRepo;
import com.onerivet.repository.FloorRepo;
import com.onerivet.repository.SeatRepo;
import com.onerivet.service.SeatConfigurationServices;

@Service
public class SeatConfigurationServiceImpl implements SeatConfigurationServices{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FloorRepo floorRepo;
	
	@Autowired
	private ColumnDetailsRepo columnDetailsRepo;
	
	@Autowired
	private SeatRepo seatRepo;

	@Override
	public List<FloorDto> getAllFloors(int cityId) {
		return floorRepo.findByCity(new City(cityId)).stream().map((floor) -> modelMapper.map(floor, FloorDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ColumnDetailsDto> getAllColumns(int floorId) {
		return columnDetailsRepo.findByFloor(new Floor(floorId)).stream().map((column) -> modelMapper.map(column, ColumnDetailsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<SeatDto> getAllSeats(int columnId) {
		return seatRepo.findByColumnDetails(new ColumnDetails(columnId)).stream().map((seat) -> modelMapper.map(seat, SeatDto.class))
				.collect(Collectors.toList());
	}
	
	
}
