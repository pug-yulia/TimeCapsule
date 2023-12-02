package com.project.TimeCapsule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TimeCapsule.domain.CapsuleNote;

import java.util.List;

public interface CapsuleNoteRepository extends JpaRepository<CapsuleNote, Long> {
	List<CapsuleNote> findAllByUsername(String username);

	CapsuleNote findByIdAndUsername(Long id, String username);

	void deleteByIdAndUsername(Long id, String username);
}