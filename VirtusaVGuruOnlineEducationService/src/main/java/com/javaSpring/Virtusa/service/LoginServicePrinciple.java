package com.javaSpring.Virtusa.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.javaSpring.Virtusa.model.StudentRegistrationDetails;


public class LoginServicePrinciple implements UserDetails {
	@Autowired
	StudentRegistrationDetails studentDetails;
	public LoginServicePrinciple(StudentRegistrationDetails studentDetails) {
		super();
		this.studentDetails = studentDetails;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("StudentRegistrationDetails"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return studentDetails.getPassword();
	}

	@Override
	public String getUsername() {
	
		return studentDetails.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
