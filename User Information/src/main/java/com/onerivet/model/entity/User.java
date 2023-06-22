package com.onerivet.model.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User Information")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int id;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name ="LastName")
	private String lastName;
	
	@Column(name = "EmailId")
	private String userName;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Role")
	private String role;
	
}
