package com.project.TimeCapsule.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<AppUser, Long> {
	    AppUser findByEmail(String email);
	    boolean existsByEmail(String email);
}

