package com.javaSpring.Virtusa.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verificationToken")
public class VerificationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String token;
	@OneToOne(fetch = FetchType.LAZY)
	private StudentRegistrationDetails student;
	private Instant expiryDate;
}
