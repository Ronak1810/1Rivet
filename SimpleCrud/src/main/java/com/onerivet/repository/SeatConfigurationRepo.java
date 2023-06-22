package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.SeatConfiguration;

public interface SeatConfigurationRepo extends JpaRepository<SeatConfiguration, Integer> {

}
