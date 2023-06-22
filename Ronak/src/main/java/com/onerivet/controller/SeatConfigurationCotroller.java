package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.payload.ColumnDetailsDto;
import com.onerivet.model.payload.FloorDto;
import com.onerivet.model.payload.SeatDto;
import com.onerivet.service.SeatConfigurationServices;

@RestController
@RequestMapping("/api/deskbook")
public class SeatConfigurationCotroller {
	
	@Autowired
	private SeatConfigurationServices seatConfigurationServices;
	
	@GetMapping("/floors/{cityId}")
	public List<FloorDto> getFloor(@PathVariable int cityId){
		return seatConfigurationServices.getAllFloors(cityId);
	}
	
	@GetMapping("/columns/{floorId}")
	public List<ColumnDetailsDto> getClumns(@PathVariable int floorId){
		return seatConfigurationServices.getAllColumns(floorId);
	}
	
	@GetMapping("/seat/{columnId}")
	public List<SeatDto> getSeat(@PathVariable int columnId){
		return seatConfigurationServices.getAllSeats(columnId);
	}

}
