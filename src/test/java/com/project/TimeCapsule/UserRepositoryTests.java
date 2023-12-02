package com.project.TimeCapsule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.TimeCapsule.domain.AppUser;
import com.project.TimeCapsule.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindUser() {
        // Save a user
        AppUser user = new AppUser("test@example.com", "password", "ROLE_USER", "TestUser", "testusername");
        userRepository.save(user);

        // Find the user by email
        AppUser foundUser = userRepository.findByEmail("test@example.com");

        // Assert that the user is found and has the correct email
        assertNotNull(foundUser);
        assertEquals("test@example.com", foundUser.getEmail());
        assertEquals("ROLE_USER", foundUser.getRole());
        assertEquals("TestUser", foundUser.getNickname());
        assertEquals("testusername", foundUser.getUsername());
    }

    @Test
    public void testExistsByEmail() {
        // Save a user
        AppUser user = new AppUser("test@example.com", "password", "ROLE_USER", "TestUser", "testusername");
        userRepository.save(user);

        // Check if the user exists by email
        boolean exists = userRepository.existsByEmail("test@example.com");

        // Assert that the user exists
        assertTrue(exists);
    }

    @Test
    public void testUserNotFound() {
        // Try to find a user with a non-existent email
        AppUser foundUser = userRepository.findByEmail("nonexistent@example.com");

        // Assert that the user is not found
        assertNull(foundUser);
    }
}
