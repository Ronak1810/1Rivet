package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.ColumnDetails;
import com.onerivet.model.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
	
	public List<Seat> findByColumnDetails(ColumnDetails column);

}
