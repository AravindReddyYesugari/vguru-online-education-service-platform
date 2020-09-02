package com.virtusa.vguru.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.vguru.model.VideoSection;
import com.virtusa.vguru.service.VideoService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {
	
	private final VideoService videoService;
	
	@GetMapping("/videos/{name}")
	public VideoSection getLinks(@PathVariable String name) {
		return videoService.getVideoLinks(name);
	}
}
