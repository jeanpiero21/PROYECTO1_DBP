package com.proyecto1.usergroup.entity;

import com.proyecto1.auth.entity.User;
import com.proyecto1.common.enums.MessageType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Representa un mensaje dentro de un grupo.
 * Puede ser texto, imagen, archivo, o mensaje del sistema.
 */
@Entity
@Table(name = "group_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageType messageType = MessageType.TEXT;

    private LocalDateTime sentAt = LocalDateTime.now();
    private Boolean read = false;

    // 🔹 Relaciones
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // autor del mensaje

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private UserGroup group; // grupo al que pertenece el mensaje
}
