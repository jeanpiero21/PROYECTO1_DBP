package com.proyecto1.event.entity;

import com.proyecto1.auth.entity.User;
import com.proyecto1.common.enums.EventStatus;
import com.proyecto1.common.enums.EventType;
import com.proyecto1.registration.entity.Registration;
import com.proyecto1.usergroup.entity.UserGroup;
import com.proyecto1.notification.entity.Notification;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String shortDescription;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private Integer capacity;
    private Integer currentAttendees = 0;

    private String imageUrl;
    private String bannerImage;
    private String qrCode;

    private String speakerInfo;
    private String speakerLinkedIn;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private Boolean requiresApproval = false;
    private BigDecimal price = BigDecimal.ZERO;
    private String currency = "PEN";

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    // 🔹 Relaciones

    @ManyToOne(optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registration> registrations = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<UserGroup> groups = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<Notification> notifications = new ArrayList<>();
}
