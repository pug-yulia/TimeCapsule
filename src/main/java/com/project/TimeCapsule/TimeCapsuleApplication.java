package com.project.TimeCapsule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.TimeCapsule.domain.AppUser;
import com.project.TimeCapsule.domain.UserRepository;

@SpringBootApplication
public class TimeCapsuleApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TimeCapsuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert a sample user for testing
        String username = "testuser";
        String password = "testpassword";

        // Check if the username is already taken
        if (userRepository.findByUsername(username) == null) {
            // Handle user registration (add to the database)
            String encodedPassword = passwordEncoder.encode(password);

            // Create a new user
            AppUser user = new AppUser();
            user.setUsername(username);
            // Set the encoded password
            user.setPassword(encodedPassword);

            // Save the user to the database
            userRepository.save(user);

            System.out.println("Sample user inserted for testing. Username: " + username + ", Password: " + password);
        } else {
            System.out.println("Sample user already exists. Skipping insertion.");
        }
    }
}
