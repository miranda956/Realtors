package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    private String firstName;
    private String lastName;
    private String email;
    private String idNumber; // New attribute
    private String contact;
    private Date moveInDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public Tenant(String firstName, String lastName, String email, String idNumber, String contact, Date moveInDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idNumber = idNumber;
        this.contact = contact;
        this.moveInDate = moveInDate;
    }
}
