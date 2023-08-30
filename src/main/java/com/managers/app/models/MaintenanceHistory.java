package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class MaintenanceHistory {
    @Id
    private String historyId; // "his" followed by 3 random digits

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private MaintenanceTask maintenanceTask;

    private Date completionDate;
    private String notes;

    // Generate a historyId with "his" and 3 random digits
    private String generateHistoryId() {
        String prefix = "HIS";
        Random random = new Random();
        int randomDigits = 100 + random.nextInt(900); // Generate a 3-digit random number
        return prefix + randomDigits;
    }

    public MaintenanceHistory(MaintenanceTask maintenanceTask, Date completionDate, String notes) {
        this.maintenanceTask = maintenanceTask;
        this.completionDate = completionDate;
        this.notes = notes;
        this.historyId = generateHistoryId();
    }
}
