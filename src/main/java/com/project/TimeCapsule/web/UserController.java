package com.project.TimeCapsule.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.TimeCapsule.domain.UserRepository;
import com.project.TimeCapsule.domain.AppUser;

@Controller
public class UserController {
	
	 @Autowired
	    private UserRepository userRepository;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	// Handles GET requests to "/login"
    @GetMapping("/custom-login")
    public String login() {
    	// Returns the name of the Thymeleaf template to render login.html
        return "/custom-login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
   
 // Handles POST requests to "/register"
    @PostMapping("/register")
    public String registerUser(Model model, String username, String password) {
        // Check if the username is already taken
        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("message", "Username is already taken. Choose another.");
            return "/custom-login";
        }

        // Handle user registration (add to the database)
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new user
        AppUser user = new AppUser();
        user.setUsername(username);
        // Set the encoded password
        user.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(user);

        model.addAttribute("message", "Registration successful! Please log in.");
        return "custom-login";
    }



    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
