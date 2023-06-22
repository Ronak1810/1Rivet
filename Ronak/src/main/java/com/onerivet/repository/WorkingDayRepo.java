package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.WorkingDay;

public interface WorkingDayRepo extends JpaRepository<WorkingDay, Integer> {

}
