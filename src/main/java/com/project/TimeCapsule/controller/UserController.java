package com.project.TimeCapsule.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.TimeCapsule.security.*;
import com.project.TimeCapsule.service.CustomUserDetailsService;
import com.project.TimeCapsule.service.UserService;
import com.project.TimeCapsule.domain.*;

@Controller
public class UserController {

	@Autowired
	CustomUserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}

	@PostMapping("/register")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        try {
            userService.save(userDto);
            model.addAttribute("message", "Registered Successfully!");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user-page")
	@Secured("ROLE_USER")
	public String userPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}

	@GetMapping("/admin-page")
	@Secured("ROLE_ADMIN")
	public String adminPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}

}