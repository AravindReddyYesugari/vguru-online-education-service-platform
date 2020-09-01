package com.javaSpring.Virtusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaSpring.Virtusa.model.StudentRegistrationDetails;


@Repository
public interface StudentRegistrationDetailsRepository extends JpaRepository<StudentRegistrationDetails, Long> {

	public StudentRegistrationDetails findByEmailId(String emailId);
}
