package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.EmployeeWorkingDays;

public interface EmployeeWorkingDaysRepo extends JpaRepository<EmployeeWorkingDays, Integer> {

}
