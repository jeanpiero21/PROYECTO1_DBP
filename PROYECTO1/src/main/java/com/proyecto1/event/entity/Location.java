package com.proyecto1.event.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private String building;
    private String room;
    private Integer capacity;

    private LocalDateTime createdAt = LocalDateTime.now();

    // 🔹 Relación con Event
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
}
