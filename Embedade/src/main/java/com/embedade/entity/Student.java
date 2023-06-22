package com.embedade.entity;

import jakarta.persistence.CascadeType;
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

@Entity
@Table(name = "students_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobileNumber;
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subject_id")
	private Subject subject;
}
