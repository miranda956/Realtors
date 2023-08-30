package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Building {
    @Id
    private String buildingId; // Format: BLOCK + 3 random numbers

    private String buildingName;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Unit> units;

    // Generate a building ID in the format "BLOCK" followed by 3 random numbers
    private String generateBuildingId() {
        String prefix = "BLOCK";
        Random random = new Random();
        int randomNumbers = 100 + random.nextInt(900); // Generate 3 random numbers between 100 and 999
        return prefix + randomNumbers;
    }

    public Building(String buildingName, String description) {
        this.buildingName = buildingName;
        this.description = description;
        this.buildingId = generateBuildingId();
    }
}
