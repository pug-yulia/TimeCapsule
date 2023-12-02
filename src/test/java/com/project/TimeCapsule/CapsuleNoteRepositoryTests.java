package com.project.TimeCapsule;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.TimeCapsule.domain.CapsuleNote;
import com.project.TimeCapsule.repository.CapsuleNoteRepository;

@DataJpaTest
public class CapsuleNoteRepositoryTests {

    @Autowired
    private CapsuleNoteRepository capsuleNoteRepository;

    @Test
    public void testSaveAndFindNoteByUsername() {
        // Save a note
        CapsuleNote note = new CapsuleNote("Test Note", "This is a test note",
                LocalDate.now(), LocalDateTime.now().plusDays(1));
        note.setUsername("testuser");
        capsuleNoteRepository.save(note);

        // Find notes by username
        List<CapsuleNote> notes = capsuleNoteRepository.findAllByUsername("testuser");

        // Assert that the note is found and has the correct title
        assertNotNull(notes);
        assertFalse(notes.isEmpty());
        assertEquals("Test Note", notes.get(0).getTitle());
    }

    @Test
    public void testFindNoteByIdAndUsername() {
        // Save a note
        CapsuleNote note = new CapsuleNote("Test Note", "This is a test note",
                LocalDate.now(), LocalDateTime.now().plusDays(1));
        note.setUsername("testuser");
        capsuleNoteRepository.save(note);

        // Find the note by id and username
        CapsuleNote foundNote = capsuleNoteRepository.findByIdAndUsername(note.getId(), "testuser");

        // Assert that the note is found and has the correct title
        assertNotNull(foundNote);
        assertEquals("Test Note", foundNote.getTitle());
    }

    @Test
    public void testDeleteNoteByIdAndUsername() {
        // Save a note
        CapsuleNote note = new CapsuleNote("Test Note", "This is a test note",
                LocalDate.now(), LocalDateTime.now().plusDays(1));
        note.setUsername("testuser");
        capsuleNoteRepository.save(note);

        // Delete the note by id and username
        capsuleNoteRepository.deleteByIdAndUsername(note.getId(), "testuser");

        // Try to find the deleted note
        CapsuleNote deletedNote = capsuleNoteRepository.findById(note.getId()).orElse(null);

        // Assert that the note is not found after deletion
        assertNull(deletedNote);
    }
}
