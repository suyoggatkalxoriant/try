package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class SchoolService {
	@Autowired
	private StudentRepository studentRepository;

	public List<StudentDto> getStudents() {
		List<Student> studentList=studentRepository.findAll();
		return studentList.stream().map(student-> studentToStudentDto(student)).toList();
	}
	
	public void saveStudent(StudentDto studentDto) {
		Student student=studentDtoToStudent(studentDto);
		studentRepository.save(student);
	}

	private StudentDto studentToStudentDto(Student student) {
		StudentDto studentDto=new StudentDto();
		studentDto.setFirstName(student.getFirstName());
		studentDto.setMiddleName(student.getMiddleName());
		studentDto.setLastName(student.getLastName());
		studentDto.setAddress(student.getAddress());
		studentDto.setEnglishMarks(student.getEnglishMarks());
		studentDto.setMarathiMarks(student.getMarathihMarks());
		studentDto.setMathsMarks(student.getMathsMarks());
		studentDto.setHindiMarks(student.getHindiMarks());
		studentDto.setSstMarks(student.getSstMarks());
		studentDto.setScienceMarks(student.getScienceMarks());
		return studentDto;
	}
	
	private Student studentDtoToStudent(StudentDto studentDto) {
		Student student=new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setMiddleName(studentDto.getMiddleName());
		student.setLastName(studentDto.getLastName());
		student.setAddress(studentDto.getAddress());
		student.setEnglishMarks(studentDto.getEnglishMarks());
		student.setMarathihMarks(studentDto.getMarathiMarks());
		student.setMathsMarks(studentDto.getMathsMarks());
		student.setHindiMarks(studentDto.getHindiMarks());
		student.setSstMarks(studentDto.getSstMarks());
		student.setScienceMarks(studentDto.getScienceMarks());
		return student;
	}

}
