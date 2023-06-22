package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.entity.City;
import com.onerivet.service.CityServices;

@RestController
@RequestMapping("/api/deskbook")
public class CityController {
	
	@Autowired
	private CityServices cityServices;
	
	@GetMapping("/cities")
	public List<City> getAllCities(){
		return cityServices.getcities();
	}

}
