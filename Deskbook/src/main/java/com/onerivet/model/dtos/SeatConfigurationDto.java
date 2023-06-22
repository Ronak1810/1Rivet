package com.onerivet.model.dtos;

import java.util.Set;

import com.onerivet.model.entity.City;
import com.onerivet.model.entity.Columns;
import com.onerivet.model.entity.Employee;
import com.onerivet.model.entity.Floor;
import com.onerivet.model.entity.Seat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatConfigurationDto {
	private int id;
	
	private Set<Employee> employee;

	private Seat seatNumber;

	private Columns columns;
	
	private Floor floor;
	
	private City city;

}
