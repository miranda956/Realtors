package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class RentInvoice {
    @Id
    private Long id;

    private String invoiceId; // Changed to a String to hold the custom format

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private Date dueDate;
    private double amount;
    private String status;
    private Date createdAt;

    @PrePersist
    public void generateInvoiceId() {
        // Generate a 5-digit random number
        int randomNum = (int) (Math.random() * 90000) + 10000;
        this.invoiceId = "INV" + randomNum;
    }
}
