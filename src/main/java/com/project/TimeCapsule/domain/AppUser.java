package com.project.TimeCapsule.domain;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
	private String email;
	private String password;
	private String role;
	private String nickname;
	private String username;
	
	public AppUser() {
		super();
	}

	public AppUser(String email, String password, String role, String nickname, String username) {
		
		this.email = email;
		this.password = password;
		this.role = role;
		this.nickname = nickname;
		this.username = username;		
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
