package com.project.TimeCapsule.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TimeCapsule.domain.AppUser;
public interface UserRepository extends JpaRepository<AppUser, Long> {
	    AppUser findByEmail(String email);
	    boolean existsByEmail(String email);
}

