package com.javaSpring.Virtusa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaSpring.Virtusa.model.VideoSection;
import com.javaSpring.Virtusa.repository.VideoSectionRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
@Transactional
public class VideoService {
private final VideoSectionRepository videoSR;
	
	public VideoSection getVideoLinks(String name) {
		return videoSR.findByName(name);
	}
}
