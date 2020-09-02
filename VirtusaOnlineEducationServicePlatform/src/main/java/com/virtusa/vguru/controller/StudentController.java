package com.virtusa.vguru.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.vguru.dto.RegisterRequest;
import com.virtusa.vguru.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/virtusa/student")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
		private final StudentService studentService;
	
		@PostMapping("/signup")
			public String signup(@RequestBody RegisterRequest registerRequest) {
			studentService.signup(registerRequest);
			return "congratulations "+"Activation email sent to "+registerRequest.getEmail();
		}

		@GetMapping("accountVerification/{token}")
		public ResponseEntity<String> verifyAccount(@PathVariable String token) {
	        studentService.verifyAccount(token);
	        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
	    }
}
	    
