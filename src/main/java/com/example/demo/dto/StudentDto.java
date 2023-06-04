package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private int englishMarks;
	private int hindiMarks;
	private int marathiMarks;
	private int scienceMarks;
	private int mathsMarks;
	private int sstMarks;
}
