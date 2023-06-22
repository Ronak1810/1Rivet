package com.onerivet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.entity.City;
import com.onerivet.repository.CityRepo;
import com.onerivet.service.CityServices;

@Service
public class CityServiceImpl implements CityServices {

	@Autowired
	private CityRepo cityRepo;

	@Override
	public List<City> getcities() {
		return cityRepo.findAll();
	}
	
	
}
