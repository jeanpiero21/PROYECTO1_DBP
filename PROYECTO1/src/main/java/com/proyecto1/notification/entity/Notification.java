package com.proyecto1.notification.entity;

import com.proyecto1.auth.entity.User;
import com.proyecto1.event.entity.Event;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationPriority priority;

    private Boolean sent = false;
    private Boolean read = false;
    private LocalDateTime scheduledTime;
    private String actionUrl;

    private LocalDateTime createdAt = LocalDateTime.now();

    // 🔹 Relaciones
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // destinatario

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event; // evento asociado (opcional)
}
