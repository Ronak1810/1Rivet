package com.onerivet.reposiretories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.model.dtos.EmployeeDto;
import com.onerivet.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


}
