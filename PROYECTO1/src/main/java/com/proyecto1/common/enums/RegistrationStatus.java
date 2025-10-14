package com.proyecto1.common.enums;

public enum RegistrationStatus {
    PENDING,     // Registro en espera de confirmación
    CONFIRMED,   // Confirmado correctamente
    CANCELLED,   // Cancelado por el usuario u organizador
    WAITLISTED,  // En lista de espera (si se llena el cupo)
    REJECTED     // Rechazado (evento cerrado o cupo lleno)
}
