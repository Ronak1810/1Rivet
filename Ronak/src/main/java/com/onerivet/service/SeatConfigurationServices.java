package com.onerivet.service;

import java.util.List;

import com.onerivet.model.payload.ColumnDetailsDto;
import com.onerivet.model.payload.FloorDto;
import com.onerivet.model.payload.SeatDto;

public interface SeatConfigurationServices {

	List<FloorDto> getAllFloors(int cityId);

	List<ColumnDetailsDto> getAllColumns(int floorId);

	List<SeatDto> getAllSeats(int columnId);

}
