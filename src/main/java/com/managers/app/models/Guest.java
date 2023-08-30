package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    private String firstName;
    private String lastName;
    private String email;
    private String contact; 
    private String reasonForVisit;
    private String duration;
    private Long idNumber;
    private Date visitDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public Guest(String firstName, String lastName, String email, String contact, String reasonForVisit, String duration, Date visitDate, Long idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
        this.reasonForVisit = reasonForVisit;
        this.duration = duration;
        this.visitDate = visitDate;
        this.idNumber = idNumber;
    }
}
