package com.managers.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class StaffShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shiftId;

    @ManyToOne
    @JoinColumn(name = "staff_profile_id")
    private StaffProfile staffProfile;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private StaffRole staffRole;

    @Temporal(TemporalType.TIME)
    private Date shiftStart;

    @Temporal(TemporalType.TIME)
    private Date shiftEnd;
}
