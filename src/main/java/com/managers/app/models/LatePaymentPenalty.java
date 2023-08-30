package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class LatePaymentPenalty {
    @Id
    private String penaltyId; // Combination of "pen" and 3 random digits

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private RentInvoice rentInvoice;

    private double penaltyAmount;
    private Date penaltyDate;
    private String reason;

    // Generate a penaltyId with "pen" and 3 random digits
    private String generatePenaltyId() {
        String prefix = "pen";
        Random random = new Random();
        int randomDigits = 100 + random.nextInt(900); // Generate a 3-digit random number
        return prefix + randomDigits;
    }

    public LatePaymentPenalty(RentInvoice rentInvoice, double penaltyAmount, Date penaltyDate, String reason) {
        this.rentInvoice = rentInvoice;
        this.penaltyAmount = penaltyAmount;
        this.penaltyDate = penaltyDate;
        this.reason = reason;
        this.penaltyId = generatePenaltyId();
    }
}
