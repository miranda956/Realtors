package com.managers.app.models;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Data
public class UserRolePermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_permission_id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRoles role;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permissions permission;
}
