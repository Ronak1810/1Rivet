package com.onerivet.model.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onerivet.model.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorkingDaysDto {
	
	private int id;
	
	private WorkingDayDto days;
	
	@JsonIgnore
	private Employee employee;

	@JsonIgnore
	private Employee createdBy;
}
