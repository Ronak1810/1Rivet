package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.payload.DesignationDto;
import com.onerivet.service.DesignationServices;

@RestController
@RequestMapping("/api/deskbook")
public class DesignationController {
	
	@Autowired
	private DesignationServices designationServices;
	
	@GetMapping("/designations")
	public List<DesignationDto> getAllDesignation(){
		return designationServices.getDesignations();
	}

}
