package com.managers.app.controller;

import com.managers.app.models.User;
import com.managers.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getUsername(), user.getEmail(), user.getPasswordHash(), user.isActive());
    }

    @PostMapping("/deactivate/{username}")
    public void deactivateUser(@PathVariable String username) {
        userService.deactivateUser(username);
    }

    @PostMapping("/activate/{username}")
    public void activateUser(@PathVariable String username) {
        userService.activateUser(username);
    }

    @PostMapping("/reset-password/{username}")
    public void resetPassword(@PathVariable String username, @RequestParam String newPassword) {
        userService.resetPassword(username, newPassword);
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String searchTerm) {
        return userService.searchUsers(searchTerm);
    }

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // TODO: Implement login endpoint

    // TODO: Implement role assignment endpoints
}
