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
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int subjectId;

	private String subjectName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
}
