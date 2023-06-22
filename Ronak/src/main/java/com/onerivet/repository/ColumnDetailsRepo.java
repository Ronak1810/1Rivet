package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.ColumnDetails;
import com.onerivet.model.entity.Floor;

public interface ColumnDetailsRepo extends JpaRepository<ColumnDetails, Integer> {
	
	public List<ColumnDetails> findByFloor(Floor floor);

}
