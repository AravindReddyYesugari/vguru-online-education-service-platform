package com.virtusa.vguru.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.vguru.model.VerificationToken;

public interface VerificationRepository extends JpaRepository<VerificationToken, Long> {
	 Optional<VerificationToken> findByToken(String token);
}
