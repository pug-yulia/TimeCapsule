package com.project.TimeCapsule.form;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class CreateNoteForm {

	private String title;
	private String message;
	private LocalDateTime openDate;

	// private MultipartFile image;

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDateTime openDate) {
		this.openDate = openDate;
	}

	/*
	 * public MultipartFile getImage() { return image; }
	 * 
	 * public void setImage(MultipartFile image) { this.image = image; }
	 */
}