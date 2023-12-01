package com.project.TimeCapsule.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CapsuleNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String message;
    private LocalDate creationDate;
    private LocalDateTime openDate;
    private String username; 
    
    // Empty constructor
    public CapsuleNote() {

    }

    public CapsuleNote(String title, String message, LocalDate creationDate, LocalDateTime openDate) {
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.openDate = openDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean canBeOpened() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.isAfter(openDate);
    }
}
