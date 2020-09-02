package com.virtusa.vguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.virtusa.vguru.model.Student;
import com.virtusa.vguru.repository.StudentRepository;


@Service
public class LoginService implements UserDetailsService {
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student =studentRepository.findByEmail(username); 
		if(student == null) {
			throw new UsernameNotFoundException("invalid username");
		}
		return new LoginServicePriciple(student);
	}
}
