package com.onerivet.deskbook.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.DeskbookUserServicesApplication;
import com.onerivet.deskbook.models.payload.CityDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.services.CityService;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/deskbook")
public class CityController {
	
	static Logger logger = LogManager.getLogger(DeskbookUserServicesApplication.class);

	@Autowired
	private CityService cityService;

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	/**
	 * @purpose: Get all cities
	 * @return: List of cityDto
	 */
	
	@GetMapping("/ronak")
	public String test() {
		logger.info("info level message ");		
		logger.warn("warn level message ");	
		logger.error("error level message ");	
		logger.debug("debug level message ");
		logger.trace("trace level message ");
		 
		return "Hello I am Ronak";
	}
	
	@GetMapping("/cities")
	public GenericResponse<List<CityDto>> getCities() {
		logger.debug("Controller Executing....");	
		GenericResponse<List<CityDto>> genericResponse = new GenericResponse<>(this.cityService.getAllCities(), null);
		return genericResponse;
	}

}
