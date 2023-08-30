package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class MaintenanceTask {
    @Id
    private String taskId; // "TASK" followed by 3 random digits

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private WorkOrder workOrder;

    private String description;
    private String location;
    private String materialsNeeded;
    private int estimatedCompletionTime;
    private String status;
    private Date completedAt;

    // Generate a taskId with "TASK" and 3 random digits
    private String generateTaskId() {
        String prefix = "TASK";
        Random random = new Random();
        int randomDigits = 100 + random.nextInt(900); // Generate a 3-digit random number
        return prefix + randomDigits;
    }

    // Constructor with required fields
    public MaintenanceTask(WorkOrder workOrder, String description, String location, String materialsNeeded,
                           int estimatedCompletionTime, String status) {
        this.workOrder = workOrder;
        this.description = description;
        this.location = location;
        this.materialsNeeded = materialsNeeded;
        this.estimatedCompletionTime = estimatedCompletionTime;
        this.status = status;
        this.taskId = generateTaskId();
    }
}
