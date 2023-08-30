package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Calendar;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class StaffProfile {
    @Id
    private Long profileId; // Remove @GeneratedValue annotation

    private String firstName;
    private String lastName;
    private String gender;
    private String contactDetails;
    private String profilePicture;

    // Generate a unique id with the last two digits of the current year and a 5-digit number
    private Long generateUniqueId() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100; // Get last two digits of the year
        Random random = new Random();
        int randomSuffix = random.nextInt(90000) + 10000; // Generates a random number between 10000 and 99999
        return Long.parseLong(currentYear + "" + randomSuffix);
    }

    // Constructor with first name, last name, gender, contact details, and profile picture
    public StaffProfile(String firstName, String lastName, String gender, String contactDetails, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.profilePicture = profilePicture;
        this.profileId = generateUniqueId();
    }
}
