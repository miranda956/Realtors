package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Property {
    @Id
    private String propertyId;

    private String propertyName;
    private String address;
    private String type;
    private String location;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Building> buildings;
    
    private String generatePropertyId() {
        String prefix = "PROP";
        String codes = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            codeBuilder.append(codes.charAt(random.nextInt(codes.length())));
        }

        return prefix + codeBuilder.toString();
    }

    public Property(String propertyName, String address, String type,String location) {
        this.propertyName = propertyName;
        this.address = address;
        this.type = type;
        this.location= location;
        this.propertyId = generatePropertyId();

    }
}
