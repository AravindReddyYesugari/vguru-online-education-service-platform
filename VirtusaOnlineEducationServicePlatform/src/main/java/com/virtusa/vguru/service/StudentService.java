package com.virtusa.vguru.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.vguru.dto.RegisterRequest;
import com.virtusa.vguru.exception.ExceptionHandler;
import com.virtusa.vguru.model.NotificationEmail;
import com.virtusa.vguru.model.Student;
import com.virtusa.vguru.model.VerificationToken;
import com.virtusa.vguru.repository.StudentRepository;
import com.virtusa.vguru.repository.VerificationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class StudentService {
	
	private final VerificationRepository verificationRepository;
	
	private final StudentRepository studentRepository;
	
	private final MailService mailService;
	
		public void signup(RegisterRequest registerRequest) {
	        Student student = new Student();
	        student.setFirstName(registerRequest.getFirstName());
	        student.setLastName(registerRequest.getLastName());
	        student.setEmail(registerRequest.getEmail());
	        student.setPassword(registerRequest.getPassword());
	        student.setCreated(Instant.now());
	        student.setEnabled(false);

	        studentRepository.save(student);

	        String token = generateVerificationToken(student);
	        mailService.sendMail(new NotificationEmail("Please Activate your Account",
	        		student.getEmail(), "Thank you for signing up to vguru online education, " +
	                "please click on the below url to activate your account : " +
	                "http://localhost:8080/virtusa/student/accountVerification/" + token));
		}
		private String generateVerificationToken(Student student) {
	        String token = UUID.randomUUID().toString();
	        VerificationToken verificationToken = new VerificationToken();
	        verificationToken.setToken(token);
	        verificationToken.setStudent(student);

	        verificationRepository.save(verificationToken);
	        return token;
	    }
	   
	    public void verifyAccount(String token) {
	        Optional<VerificationToken> verificationToken = verificationRepository.findByToken(token);
	        fetchUserAndEnable(verificationToken.orElseThrow(() -> new ExceptionHandler("Invalid Token")));
	    }
	    
	    
	    private void fetchUserAndEnable(VerificationToken verificationToken) {
	        String username = verificationToken.getStudent().getEmail();
	        Student student = studentRepository.findByEmail(username);
//	        .orElseThrow(() -> new SpringRedditException("User not found with name - " + username));
	        student.setEnabled(true);
	        studentRepository.save(student);
	    }
}
