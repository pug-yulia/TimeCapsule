package com.project.TimeCapsule.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.TimeCapsule.form.CreateNoteForm;
import com.project.TimeCapsule.service.CapsuleNoteService;
import com.project.TimeCapsule.domain.*;

@Controller
public class NoteController {

	private final CapsuleNoteService capsuleNoteService;

	@Autowired
	public NoteController(CapsuleNoteService capsuleNoteService) {
		this.capsuleNoteService = capsuleNoteService;
	}

	@GetMapping("/create-note")
	public String getCreateNoteForm(Model model) {
		// Add an instance of the form class to the model to bind the form data
		model.addAttribute("createNoteForm", new CreateNoteForm());
		return "create-note";
	}

	/*
	 * @PostMapping("/create-note") public String createNote(
	 * 
	 * @ModelAttribute("createNoteForm") CreateNoteForm createNoteForm,
	 * 
	 * @RequestParam("image") MultipartFile image, Model model) { // Process the
	 * form data and save the new note CapsuleNote newNote = new CapsuleNote();
	 * 
	 * // Handle image upload /* try { newNote.setImageData(image.getBytes()); }
	 * catch (IOException e) { // Handle the exception }
	 * 
	 * capsuleNoteService.saveCapsuleNote(newNote);
	 * 
	 * 
	 * return "redirect:/home"; }
	 */

	@PostMapping("/create-note")
	public String createNote(@ModelAttribute("createNoteForm") CreateNoteForm createNoteForm, Model model) {
		// Process the form data and save the new note
		CapsuleNote newNote = new CapsuleNote();
		newNote.setTitle(createNoteForm.getTitle());
		newNote.setMessage(createNoteForm.getMessage());
		newNote.setOpenDate(createNoteForm.getOpenDate());
		newNote.setCreationDate(LocalDate.now());

		capsuleNoteService.saveCapsuleNote(newNote);

		return "redirect:/home";
	}

	@GetMapping("/view-note/{id}")
	public String viewNote(@PathVariable Long id, Model model) {
		CapsuleNote note = capsuleNoteService.getCapsuleNoteById(id);

		if (note != null) {
			model.addAttribute("note", note);

			if (note.canBeOpened()) {
				// Return a view name indicating the note can be opened
				return "view-note";
			} else {
				// Return a special string indicating the note can't be opened yet
				return "note-not-available";
			}
		} else {
			// Handle the case where the note with the given ID is not found
			return "redirect:/home";
		}
	}

	@PostMapping("/delete-note/{id}")
	public String deleteNote(@PathVariable Long id) {
		capsuleNoteService.deleteCapsuleNoteById(id);
		return "redirect:/home";
	}

}