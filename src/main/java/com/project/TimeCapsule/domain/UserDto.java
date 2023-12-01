package com.project.TimeCapsule.domain;

public class UserDto {

	private String email;
	private String password;
	private String role;
	private String nickname;
	private String username;

	public UserDto(String email, String password, String role, String username, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.username = username;
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
