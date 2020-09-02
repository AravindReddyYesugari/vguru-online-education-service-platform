package com.virtusa.vguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.vguru.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	public Student findByEmail(String username);
}
