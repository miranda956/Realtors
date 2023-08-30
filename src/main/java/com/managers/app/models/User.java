package com.managers.app.models;

import lombok.Data;

import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    private String username;
    private String email;
    private String passwordHash;
    private boolean isActive;
    private Date registrationDate;
    private Date lastLogin;
    
    private Long generateUniqueId() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100; // Get last two digits of the year
        Random random = new Random();
        int randomSuffix = random.nextInt(90000) + 10000; // Generates a random number between 10000 and 99999
        return Long.parseLong(currentYear + "" + randomSuffix);
    }

    public User(String username, String email, String passwordHash, boolean isActive) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isActive = isActive;
        this.registrationDate = new Date(System.currentTimeMillis());
        this.lastLogin = new Date(System.currentTimeMillis());
        this.id = generateUniqueId();

    }
    
    
    

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
