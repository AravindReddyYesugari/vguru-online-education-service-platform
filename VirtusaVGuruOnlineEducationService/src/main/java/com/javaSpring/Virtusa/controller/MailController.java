package com.javaSpring.Virtusa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaSpring.Virtusa.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/virtusa/student")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MailController {
	
	private final StudentService studentService;
	
	@GetMapping("accountVerification/{token}")
	public  ResponseEntity<String> verifyAccount(@PathVariable String token){
		studentService.verifyAccount(token);
		return new ResponseEntity<>("account activated successfuylly",
				HttpStatus.OK);
	}

}
