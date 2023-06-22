package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.payload.WorkingDayDto;
import com.onerivet.service.WorkingDayServices;

@RestController
@RequestMapping("/api/deskbook")
public class WorkingDayController {

	@Autowired
	private WorkingDayServices workingDayServices;
	
	@GetMapping("/working-days")
	public List<WorkingDayDto> getWorkigDays(){
		return workingDayServices.getAllWorkingDays();
	}
}
