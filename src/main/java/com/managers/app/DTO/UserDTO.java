package com.managers.app.DTO;


public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private boolean isActive;
    // Other fields that you want to include in the DTO

    // Constructors
    public UserDTO(Long id, String username, String email, boolean isActive) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.isActive = isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
