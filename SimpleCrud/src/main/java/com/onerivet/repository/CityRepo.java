package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}
