package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.entity.Designation;

public interface DesignationRepo extends JpaRepository<Designation, Integer> {

}
