package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    private String propertyName;
    private String address;
    private String type;
    private String location;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Building> buildings;

    public Property(String propertyName, String address, String type,String location) {
        this.propertyName = propertyName;
        this.address = address;
        this.type = type;
        this.location= location;
    }
}
