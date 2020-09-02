package com.virtusa.vguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.virtusa.vguru.model.VideoSection;

public interface VideoRepository extends JpaRepository<VideoSection, Long> {
	@Query(value = "select vd from VideoSection vd where vd.name = ?1")
	public VideoSection findByName(String name);
}
