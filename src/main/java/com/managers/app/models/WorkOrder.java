package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class WorkOrder {
    @Id
    private String orderId; // "ORD" followed by 4 random numbers

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    private MaintenanceRequest maintenanceRequest;

    private String assignedTo;
    private Date scheduledDate;
    private String status;
    private double costEstimate;
    private Date createdAt;

    // Generate an orderId with "ORD" and 4 random numbers
    private String generateOrderId() {
        String prefix = "ORD";
        String digits = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            codeBuilder.append(digits.charAt(random.nextInt(digits.length())));
        }

        return prefix + codeBuilder.toString();
    }

    // Constructor with required fields
    public WorkOrder( String assignedTo, Date scheduledDate, String status, double costEstimate) {
        this.assignedTo = assignedTo;
        this.scheduledDate = scheduledDate;
        this.status = status;
        this.costEstimate = costEstimate;
        this.createdAt = new Date();
        this.orderId = generateOrderId();
    }
}
