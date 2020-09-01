package com.javaSpring.Virtusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaSpring.Virtusa.model.VideoSection;

@Repository
public interface VideoSectionRepository extends JpaRepository<VideoSection, Long> {
	@Query(value = "select vd from VideoSection vd where vd.name = ?1")
	public VideoSection findByName(String name);
}
