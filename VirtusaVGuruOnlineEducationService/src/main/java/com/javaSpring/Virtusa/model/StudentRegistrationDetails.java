package com.javaSpring.Virtusa.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vgurustudentdetails")
public class StudentRegistrationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "firstName is required")
	private String firstName;
	@NotBlank(message = "lastName is required")
	private String lastName;
	@Email
	@NotEmpty(message = "emailId required")
	private String emailId;
	@NotBlank(message = "password is required")
	private String password;
	@NotBlank(message = "number is required")
	private long number;
	private Instant created;
	private boolean enabled;
}
