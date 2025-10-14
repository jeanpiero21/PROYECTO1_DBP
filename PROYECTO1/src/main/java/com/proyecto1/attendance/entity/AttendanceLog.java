package com.proyecto1.attendance.entity;

import com.proyecto1.registration.entity.Registration;
import com.proyecto1.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime checkInTime = LocalDateTime.now();
    private String method; // QR_SCAN, MANUAL, NFC
    private String deviceInfo;
    private String notes;

    @ManyToOne(optional = false)
    private Registration registration;

    @ManyToOne(optional = false)
    private User scannedBy;
}
