package com.proyecto1.auth.entity;

import com.proyecto1.common.enums.Role;
import com.proyecto1.event.entity.Event;
import com.proyecto1.registration.entity.Registration;
import com.proyecto1.attendance.entity.AttendanceLog;
import com.proyecto1.usergroup.entity.GroupMember;
import com.proyecto1.usergroup.entity.GroupMessage;
import com.proyecto1.notification.entity.Notification;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String studentId;
    private String profileImage;
    private String phone;

    private Boolean emailNotifications = true;
    private Boolean pushNotifications = true;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    // 🔹 Relaciones
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> organizedEvents = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registration> registrations = new ArrayList<>();

    @OneToMany(mappedBy = "scannedBy")
    private List<AttendanceLog> scannedAttendances = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<GroupMember> groupMemberships = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<GroupMessage> messages = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();
}
