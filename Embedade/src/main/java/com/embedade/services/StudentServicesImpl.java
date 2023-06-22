package com.embedade.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embedade.entity.Address;
import com.embedade.entity.Student;
import com.embedade.entity.Subject;
import com.embedade.payload.StudentDto;
import com.embedade.repository.StudentRepository;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String add(StudentDto studentDto) {
		Student student = studentDtoToStudent(studentDto);
		student.getSubject().setStudent(student);
		studentRepository.save(student);
		return "Student add Successfully...";
	}

	@Override
	public List<StudentDto> getAll() {
		return studentRepository.findAll().stream().map(this::studentToStudentDto).collect(Collectors.toList());
	}

	@Override
	public String delete(int id) {
		Student student = studentRepository.findById(id).get();
		if (student == null)
			return "Please Enter valid Id";
		studentRepository.delete(student);
		return "Delete Successfully";
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public String update(StudentDto studentDto, Integer id) {

		Student student = studentRepository.findById(id).get();
		studentRepository.save(student);
		if (student == null)
			return "Please Enter valid Id";

		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setPassword(studentDto.getPassword());
		student.setMobileNumber(studentDto.getMobileNumber());
		student.setAddress(this.modelMapper.map(studentDto.getAddress(), Address.class));
		studentDto.setId(student.getId());
		studentDto.getSubject().setSubjectId(student.getSubject().getSubjectId());
		student.setSubject(this.modelMapper.map(studentDto.getSubject(), Subject.class));
		studentRepository.save(student);
		return "Updated";
	}

	public StudentDto studentToStudentDto(Student student) {
		StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
		return studentDto;

	}

	public Student studentDtoToStudent(StudentDto studentDto) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		return student;
	}

	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

}
