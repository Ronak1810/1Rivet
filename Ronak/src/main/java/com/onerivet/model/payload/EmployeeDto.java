package com.onerivet.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private String id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String profilePictureFileName;
	
	private String profilepictureFilePath;
	
	private ModeOfWorkDto modeOfWork;
	
	private DesignationDto designation;

}
