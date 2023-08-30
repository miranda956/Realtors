package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Unit {
    @Id
    private String unitId; // "UNIT" followed by 3 random codes

    private String unitNumber;
    private String unitType;
    private String availabilityStatus;
    private double rentalRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    // Generate a unitId with "UNIT" and 3 random codes
    private String generateUnitId() {
        String prefix = "UNIT";
        String codes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            codeBuilder.append(codes.charAt(random.nextInt(codes.length())));
        }

        return prefix + codeBuilder.toString();
    }

    // Constructor with required fields
    public Unit(String unitNumber, String unitType, String availabilityStatus, double rentalRate) {
        this.unitNumber = unitNumber;
        this.unitType = unitType;
        this.availabilityStatus = availabilityStatus;
        this.rentalRate = rentalRate;
        this.unitId = generateUnitId();
    }
}
