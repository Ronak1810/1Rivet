package com.onerivet.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "[Employee]", schema = "[dbo]")
public class Employee {
	
	@Id
	@Column(name = "EmployeeId")
	private String id;
	
	@Column(name = "EmailId")
	private String email;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "ProfilePictureFileName")
	private String profilePictureFileName;
	
	@Column(name = "ProfilePictureFilePath")
	private String profilePictureFilePath;
	
	@OneToOne
	@JoinColumn(name = "ModeOFWorkId")
	private ModeOfWork modeOfWork;
	
	@OneToOne
	@JoinColumn(name = "DesignationId")
	private Designation designation;
	
	@Column(name = "ModifiedDate")
	private LocalDateTime modifiedDate;
	
	@OneToOne
	@JoinColumn(name = "ModifiedBy")
	private Employee modifiedBy;

}
