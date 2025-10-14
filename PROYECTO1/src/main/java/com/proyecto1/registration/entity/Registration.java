package com.proyecto1.registration.entity;

import com.proyecto1.auth.entity.User;
import com.proyecto1.event.entity.Event;
import com.proyecto1.common.enums.CheckInMethod;
import com.proyecto1.common.enums.RegistrationStatus;
import com.proyecto1.attendance.entity.AttendanceLog;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa la inscripción de un usuario a un evento.
 * Incluye QR, estado de registro, método de check-in y confirmación de asistencia.
 */
@Entity
@Table(name = "registrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Fecha en que el usuario se registró
    @Column(nullable = false)
    private LocalDateTime registrationDate = LocalDateTime.now();

    // 🔹 Código QR asignado al registro
    private String qrCode;

    // 🔹 Número de ticket o identificador único
    @Column(unique = true)
    private String ticketNumber;

    // 🔹 Indica si el usuario asistió o no
    private Boolean attended = false;

    // 🔹 Hora de check-in (asistencia)
    private LocalDateTime checkInTime;

    // 🔹 Método usado para registrar asistencia (QR, manual, NFC, etc.)
    @Enumerated(EnumType.STRING)
    private CheckInMethod checkInMethod;

    // 🔹 Estado general del registro (PENDING, CONFIRMED, CANCELLED...)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus registrationStatus = RegistrationStatus.PENDING;

    // 🔹 Relaciones principales
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Usuario que se registra

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event; // Evento al que se registra

    // 🔹 Relación con asistencias (por si hay más de un registro de entrada)
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceLog> attendanceLogs = new ArrayList<>();
}
