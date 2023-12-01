package com.project.TimeCapsule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.TimeCapsule.domain.CapsuleNote;
import com.project.TimeCapsule.repository.CapsuleNoteRepository;

import java.util.List;

@Service
public class CapsuleNoteService {

    private final CapsuleNoteRepository capsuleNoteRepository;

    @Autowired
    public CapsuleNoteService(CapsuleNoteRepository capsuleNoteRepository) {
        this.capsuleNoteRepository = capsuleNoteRepository;
    }

    public List<CapsuleNote> getAllCapsuleNotesForCurrentUser() {
        // Get the current authenticated user's username
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Fetch notes based on the username
        return capsuleNoteRepository.findAllByUsername(username);
    }

    public void saveCapsuleNote(CapsuleNote capsuleNote) {
        // Set the username for the note based on the current authenticated user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        capsuleNote.setUsername(username);

        capsuleNoteRepository.save(capsuleNote);
    }

    public CapsuleNote getCapsuleNoteById(Long id) {
        // Fetch note based on ID and the current authenticated user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return capsuleNoteRepository.findByIdAndUsername(id, username);
    }

    @Transactional
    public void deleteCapsuleNoteById(Long id) {
        // Delete note based on ID and the current authenticated user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        capsuleNoteRepository.deleteByIdAndUsername(id, username);
    }
}
