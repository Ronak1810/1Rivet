package com.onerivet.model.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee", schema="dbo")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "EmployeeId")
	private int id;
	
	@Column(name = "UserId")
	private String userId;
	
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "Project")
	private String project;
	
	@Column(name = "ProfilePictureFileName")
	private String profilePictureFileName;
	
	@Column(name = "ProfilePictureFilePath")
	private String profilePictureFilePath;
	
	
	@ManyToMany
	@JoinTable(name = "EmployeeWorkingDays", schema = "dbo", 
		joinColumns = {
			@JoinColumn(name = "EmployeeId")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "WorkingDayId")
	})
	private Set<WorkingDay> workingDay;
	
	
	@ManyToMany
	@JoinTable(name = "EmployeeRole", schema = "dbo", 
		joinColumns = {
			@JoinColumn(name = "RoleId")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "EmployeeId")
	})
	private Set<Role> role;
	
	@OneToOne
	@JoinColumn(name = "DesignationId")
	private Designation designation;
	
	@OneToOne
	@JoinColumn(name = "ModeOfWorkId")
	private ModeOfWork modeOfWork;
		
}
