package com.project.TimeCapsule.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.TimeCapsule.domain.*;
import com.project.TimeCapsule.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public AppUser save(UserDto userDto) {
	    // Check if the email is already registered
	    if (userRepository.existsByEmail(userDto.getEmail())) {
	        throw new RuntimeException("Email is already registered");
	    }

	    // Set default role to "USER"
	    String defaultRole = "USER";

	    AppUser user = new AppUser(
	        userDto.getEmail(),
				passwordEncoder.encode(userDto.getPassword()), defaultRole, // Set default role
	        userDto.getUsername(),
	        userDto.getNickname()
	    );
	    System.out.println("User has " + userDto.getRole() + " role.");
	    return userRepository.save(user);
	}
}