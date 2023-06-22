package com.onerivet.model.dtos;

import jakarta.validation.constraints.Email;
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
public class EmployeeDto {
	
	private int id;
	
	private String userId;
	
	@Email
	private String emailId;
	
	@NotEmpty(message = "Please enter a valid first Name")
	@Size (min = 3, message = "First name must be of 3 characters or more.")
	@Size (max = 100, message = "Your First name cannot exceed 100 characters.")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message ="Please enter valid First name.")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message ="First letter must be capital.")
	private String firstName;
	
	@NotEmpty(message = "Please enter a valid first Name.")
	@Size (min = 3, message = "Last name must be of 3 characters or more.")
	@Size (max = 100, message = "Your Last name cannot exceed 100 characters.")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message ="Please enter valid First name.")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message ="First letter must be capital.")
	private String lastName;
	
	@NotEmpty(message = "Please enter a numeric value only")
	@Size (min = 10, message = "Phone number must be of 10 characters only.")
	@Size (max = 10, message = "Your Phone number cannot exceed 10 characters.")
	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;
	
	private String project;
	
	private String profilePictureFileName;
	
	private String profilePictureFilePath;
	
}
