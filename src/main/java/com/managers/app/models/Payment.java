package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Payment {
    @Id
    private String paymentCode; // Payment code as primary key

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private RentInvoice rentInvoice;

    private Date paymentDate;
    private double amount;
    private String paymentMethod;
    private Date createdAt;

    // Generate a unique payment code using a combination of letters and digits
    private String generatePaymentCode() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        
        StringBuilder codeBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            codeBuilder.append(letters.charAt(random.nextInt(letters.length())));
            codeBuilder.append(digits.charAt(random.nextInt(digits.length())));
        }

        return codeBuilder.toString();
    }

    // Constructor with required fields
    public Payment(Tenant tenant, RentInvoice rentInvoice, Date paymentDate, double amount, String paymentMethod) {
        this.tenant = tenant;
        this.rentInvoice = rentInvoice;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.createdAt = new Date();
        this.paymentCode = generatePaymentCode();
    }
}
