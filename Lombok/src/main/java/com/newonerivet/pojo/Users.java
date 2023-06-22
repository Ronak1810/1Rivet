package com.newonerivet.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Users {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private String email;
	private String password;
	private String mobileNumber;

}
