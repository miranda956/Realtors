package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Expense {
    @Id
    private String expenseId; // 4-digit random number

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    private String description;
    private double amount;
    private Date expenseDate;
    private Date createdAt;

    // Generate a 4-digit random number for expenseId
    private String generateExpenseId() {
        Random random = new Random();
        int randomId = 1000 + random.nextInt(9000); // Generate a 4-digit random number
        return String.valueOf(randomId);
    }

    public Expense(Property property, String description, double amount, Date expenseDate) {
        this.property = property;
        this.description = description;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.createdAt = new Date();
        this.expenseId = generateExpenseId();
    }
}
