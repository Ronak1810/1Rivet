package com.embedade.payload;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private int id;
	
	@NotEmpty
	@Size(min=2,max=30,message="Name should be between 2 and 30 character")
	private String firstName;
	
	@NotEmpty
	@Size(min=2,max=30,message="Name should be between 2 and 30 character")
	private String lastName;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	@NotEmpty(message="Please enter strong password")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
	private String password;
	
	@NotEmpty(message="Please enter valid phone number")
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobileNumber;
	

	@Valid
	private AddressDto address;

	@Valid
	private SubjectDto subject;
}
