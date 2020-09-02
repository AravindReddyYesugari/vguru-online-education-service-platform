package com.virtusa.vguru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "videosection")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoSection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="video1")
	private String video1;
	@Column(name="video2")
	private String video2;
	@Column(name="video3")
	private String video3;
	@Column(name ="video4")
	private String video4;
	@Column(name = "video5")
	private String video5;
	@Column(name = "video6")
	private String video6;
	@Column(name = "video7")
	private String video7;
	@Column(name = "video8")
	private String video8;
	@Column(name = "video9")
	private String video9;
}
