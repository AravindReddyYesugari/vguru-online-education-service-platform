package com.javaSpring.Virtusa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "videoSection")
public class VideoSection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String video1;
	private String video2;
	private String video3;
	private String video4;
	private String video5;
	private String video6;
	private String video7;
	private String video8;
	private String video9;
}
