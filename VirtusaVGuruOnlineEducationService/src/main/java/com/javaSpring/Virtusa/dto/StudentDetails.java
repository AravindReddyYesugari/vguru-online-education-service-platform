package com.javaSpring.Virtusa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails {
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private long number;
}
