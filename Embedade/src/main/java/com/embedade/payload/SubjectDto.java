package com.embedade.payload;


import com.embedade.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

	private int subjectId;
	
	@NotEmpty(message = "Please enter subject name")
	private String subjectName;
	
	@JsonIgnore
	private Student student;
}
