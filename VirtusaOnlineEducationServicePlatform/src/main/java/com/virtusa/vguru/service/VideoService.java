package com.virtusa.vguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.vguru.model.VideoSection;
import com.virtusa.vguru.repository.VideoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class VideoService {
	@Autowired
	private VideoRepository videoRepository;
	
	public VideoSection getVideoLinks(String name) {
		// TODO Auto-generated method stub
		return videoRepository.findByName(name);
	}
}
