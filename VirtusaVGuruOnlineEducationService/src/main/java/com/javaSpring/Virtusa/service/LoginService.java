package com.javaSpring.Virtusa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaSpring.Virtusa.model.StudentRegistrationDetails;
import com.javaSpring.Virtusa.repository.StudentRegistrationDetailsRepository;


@Service
public class LoginService implements UserDetailsService {
	@Autowired
	private StudentRegistrationDetailsRepository studentRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentRegistrationDetails studentDetails =studentRepository.findByEmailId(username); 
		if(studentDetails == null) {
			throw new UsernameNotFoundException("invalid username");
		}
		return new LoginServicePrinciple(studentDetails);
	}
}
