package com.managers.app.service;

import com.managers.app.models.User;
import com.managers.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create User
    public User createUser(String username, String email, String password, boolean isActive) {
        String passwordHash = passwordEncoder.encode(password);
        User newUser = new User(username, email, passwordHash, isActive);
        return userRepository.save(newUser);
    }

    // Deactivate User   
    public void deactivateUser(String username) {
        User user = userRepository.findByUsernameAndIsActive(username, true);
        if (user != null) {
            user.setActive(false);
            userRepository.save(user);
        }
    }
    
    // Activate User Account
    public void activateUser(String username) {
        User user = userRepository.findByUsernameAndIsActive(username, true);
        if (user != null) {
            user.setActive(true);
            userRepository.save(user);
        }
    }

    // Reset Password
    public void resetPassword(String username, String newPassword) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            String newPasswordHash = passwordEncoder.encode(newPassword);
            user.setPasswordHash(newPasswordHash);
            userRepository.save(user);
        }
    }

    // Search Users
    public List<User> searchUsers(String searchTerm) {
        return userRepository.findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(searchTerm, searchTerm);
    }

    // List All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // TODO: Implement Login Functionality   
    // This could involve integrating with Spring Security for authentication and token generation.
         
    // TODO: Implement Role Assignment Functionality
    // This could involve associating users with roles or permissions.
}
