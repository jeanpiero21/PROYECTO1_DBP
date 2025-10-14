package com.proyecto1.event.entity;

import com.proyecto1.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private String shortDescription;

    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;

    private Integer capacity;
    private Integer currentAttendees = 0;

    private String imageUrl;
    private String bannerImage;
    private String qrCode;

    private String speakerInfo;
    private String speakerLinkedIn;

    @Enumerated(EnumType.STRING)
    private EventStatus status; // DRAFT, PUBLISHED, CANCELLED, COMPLETED

    @Enumerated(EnumType.STRING)
    private EventType eventType; // VIRTUAL, IN_PERSON, HYBRID

    private Boolean requiresApproval = false;
    private BigDecimal price = BigDecimal.ZERO;
    private String currency = "PEN";

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne(optional = false)
    private User organizer;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne
    private Location location;
}

