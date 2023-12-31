package com.project.TimeCapsule.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.TimeCapsule.domain.CapsuleNote;
import com.project.TimeCapsule.service.CapsuleNoteService;

@Controller
public class HomeController {

	private final CapsuleNoteService capsuleNoteService;

	@Autowired
	public HomeController(CapsuleNoteService capsuleNoteService) {
		this.capsuleNoteService = capsuleNoteService;
	}
	
	@GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/index";
	}

	@GetMapping("/home")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()) {
			String username = authentication.getName();
			model.addAttribute("username", username);

			// Retrieve and display capsule notes for the current user
			List<CapsuleNote> capsuleNotes = capsuleNoteService.getAllCapsuleNotesForCurrentUser();
			model.addAttribute("capsuleNotes", capsuleNotes);
			System.out.println("Principal: " + authentication.getPrincipal());
		}

		return "home";
	}
}