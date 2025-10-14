package com.proyecto1.usergroup.entity;

import com.proyecto1.auth.entity.User;
import com.proyecto1.event.entity.Event;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un grupo de usuarios asociado a un evento.
 * Puede tener un creador, miembros y mensajes.
 */
@Entity
@Table(name = "user_groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String groupImage;
    private Integer maxMembers = 10;
    private String joinCode;

    @Enumerated(EnumType.STRING)
    private GroupPrivacy privacy = GroupPrivacy.PUBLIC; // PUBLIC o PRIVATE

    private LocalDateTime createdAt = LocalDateTime.now();

    // 🔹 Relaciones principales
    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event; // Grupo asociado a un evento

    @ManyToOne(optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy; // Usuario creador

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupMember> members = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupMessage> messages = new ArrayList<>();
}
