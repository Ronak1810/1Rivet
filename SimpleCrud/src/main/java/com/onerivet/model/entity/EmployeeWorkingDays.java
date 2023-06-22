package com.onerivet.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[EmployeeWorkingDays]", schema = "[dbo]")
public class EmployeeWorkingDays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "EmployeeWorkingDayId")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EmployeeId")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WorkingDayId")
	private WorkingDay workingDay;
	
	@OneToOne
	@JoinColumn(name = "CreatedBy")
	private Employee createdBy; 
	
	@Column(name = "ModifiedDate")
	private LocalDate modifiedDate;
	
	@OneToOne
	@JoinColumn(name = "ModifiedBy")
	private Employee modifiedBy;
	
	@Column(name = "DeletedDate")
	private LocalDate deletedDate;
	
	@OneToOne
	@JoinColumn(name = "DeletedBy")
	private Employee deletedBy;	
	
}
