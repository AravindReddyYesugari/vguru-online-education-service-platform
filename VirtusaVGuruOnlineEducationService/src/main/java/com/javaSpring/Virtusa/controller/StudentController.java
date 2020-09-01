package com.javaSpring.Virtusa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.javaSpring.Virtusa.dto.StudentDetails;
import com.javaSpring.Virtusa.model.VideoSection;
import com.javaSpring.Virtusa.service.StudentService;
import com.javaSpring.Virtusa.service.VideoService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	private final VideoService videoS;
	
	private final StudentService studentService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody StudentDetails student) {
		studentService.signUp(student);
		return  new ResponseEntity<>("Activate your email for successfull registration"+student.getEmailId(),
				HttpStatus.OK);
	}
	
//	@GetMapping("accountVerification/{token}")
//	public  ResponseEntity<String> verifyAccount(@PathVariable String token){
//		studentService.verifyAccount(token);
//		return new ResponseEntity<>("account activated successfuylly",
//				HttpStatus.OK);
//	}

	@GetMapping("/videos/{name}")
	public VideoSection getLinks(@PathVariable String name) {
		return videoS.getVideoLinks(name);
	}
	 
}
