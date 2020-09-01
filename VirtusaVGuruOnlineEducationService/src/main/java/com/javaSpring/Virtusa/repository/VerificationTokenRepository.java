package com.javaSpring.Virtusa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.Virtusa.model.VerificationToken;


@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	Optional<VerificationToken> findByToken(String token);
}
