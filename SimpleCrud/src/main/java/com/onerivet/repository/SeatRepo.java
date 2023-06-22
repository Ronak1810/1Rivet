package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {

}
