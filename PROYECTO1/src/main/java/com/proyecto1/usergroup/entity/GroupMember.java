package com.proyecto1.usergroup.entity;

import com.proyecto1.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Relación entre un usuario y un grupo.
 * Define su rol (admin, moderador o miembro) dentro del grupo.
 */
@Entity
@Table(name = "group_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GroupRole role = GroupRole.MEMBER;

    private LocalDateTime joinedAt = LocalDateTime.now();

    // 🔹 Relaciones
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private UserGroup group;
}
