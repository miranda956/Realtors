package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class MaintenanceRequest {
    @Id
    private String requestId; // "REQ" followed by 3 random digits

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private String issueDescription;
    private String urgency;
    private Date preferredSchedule;
    private String status;
    private Date createdAt;

    // Generate a requestId with "REQ" and 3 random digits
    private String generateRequestId() {
        String prefix = "REQ";
        Random random = new Random();
        int randomDigits = 100 + random.nextInt(900); // Generate a 3-digit random number
        return prefix + randomDigits;
    }

    // Constructor with required fields
    public MaintenanceRequest(Tenant tenant, Unit unit, String issueDescription, String urgency, Date preferredSchedule, String status) {
        this.tenant = tenant;
        this.unit = unit;
        this.issueDescription = issueDescription;
        this.urgency = urgency;
        this.preferredSchedule = preferredSchedule;
        this.status = status;
        this.createdAt = new Date();
        this.requestId = generateRequestId();
    }
}
