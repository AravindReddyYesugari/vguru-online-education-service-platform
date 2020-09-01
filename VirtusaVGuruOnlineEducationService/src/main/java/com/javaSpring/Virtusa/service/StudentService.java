package com.javaSpring.Virtusa.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaSpring.Virtusa.dto.StudentDetails;
import com.javaSpring.Virtusa.exception.VguruMailException;
import com.javaSpring.Virtusa.model.NotificationEmail;
import com.javaSpring.Virtusa.model.StudentRegistrationDetails;
import com.javaSpring.Virtusa.model.VerificationToken;
import com.javaSpring.Virtusa.repository.StudentRegistrationDetailsRepository;
import com.javaSpring.Virtusa.repository.VerificationTokenRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
	private final StudentRegistrationDetailsRepository studentRDR;
	private final VerificationTokenRepository verificationTokenR;
	private final MailService mailService;
	
	
	public void signUp(StudentDetails studentD) {
		StudentRegistrationDetails studentRD = new StudentRegistrationDetails();
		studentRD.setFirstName(studentD.getFirstName());
		studentRD.setLastName(studentD.getLastName());
		studentRD.setEmailId(studentD.getEmailId());
		studentRD.setPassword(studentD.getPassword());
		studentRD.setNumber(studentD.getNumber());
		studentRD.setEnabled(false);
		studentRD.setCreated(Instant.now());
		
		studentRDR.save(studentRD);
		
		String token = generateVerificationToken(studentRD);
		
		 mailService.sendMail(new NotificationEmail("Please Activate your Account",
	                studentRD.getEmailId(), "Thank you for signing up to Spring Reddit, " +
	                "please click on the below url to activate your account : " +
	                "http://localhost:8080/virtusa/student/accountVerification/" + token));
		
	}
	

	private String generateVerificationToken(StudentRegistrationDetails studentRD) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setStudent(studentRD);
		
		verificationTokenR.save(verificationToken);
		
		
		return token;
	}

	public void verifyAccount(String token) {
		
		Optional<VerificationToken> verificationToken = verificationTokenR.findByToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new VguruMailException("Invalid Token")));
	}
	
	private void fetchUserAndEnable(VerificationToken verificationToken) {
        String emailId = verificationToken.getStudent().getEmailId();
//        StudentRegistrationDetails StudentRD = studentRDR.findByEmailId(emailId).orElseThrow(() -> new VguruMailException("User not found with name - " + emailId));
      try {
        StudentRegistrationDetails StudentRD = studentRDR.findByEmailId(emailId);
        StudentRD.setEnabled(true);
        studentRDR.save(StudentRD);
      }
      catch(Exception e) {
    	  throw new VguruMailException("user not found");
      }
       
    }
	
}
