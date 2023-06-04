package com.example.demo.controller;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.SchoolService;



@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
	
	Logger logger=LoggerFactory.getLogger(SchoolController.class);
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/get-student")
	public ResponseEntity<List<StudentDto>> getStudent() {
		logger.info("get student controller start");
		List<StudentDto> studentList= schoolService.getStudents();
		logger.info("get student controller end");
		return ResponseEntity.ok(studentList);
	}
	
	@PostMapping("/create-student")
	public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto) {
		logger.info("create student controller start");
		schoolService.saveStudent(studentDto);
		logger.info("create student controller end");
		return ResponseEntity.status(HttpStatus.CREATED).body("Student saved successfully");
	}
}
