package com.proyecto1.event.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "event_tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tagName;

    // 🔹 Relación Many-to-One con Event
    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
