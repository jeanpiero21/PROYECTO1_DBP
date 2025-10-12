## 🗂️ Estructura del proyecto

El backend está organizado bajo una arquitectura **modular por dominio**, siguiendo el patrón **Controller–Service–Repository** de Spring Boot.

src/
├── main/java/com/proyecto1/
│ ├── config/ → Configuración general (seguridad, JWT, Swagger, etc.)
│ ├── exception/ → Excepciones personalizadas y manejador global
│ ├── common/ → Enums, DTOs genéricos, utilidades y constantes
│ ├── auth/ → Autenticación, usuarios y roles
│ ├── event/ → Gestión de eventos, categorías y ubicaciones
│ ├── registration/ → Registros de usuarios en eventos
│ ├── group/ → Grupos, miembros y chat
│ ├── attendance/ → Control de asistencia con QR
│ └── notification/ → Sistema de notificaciones (push/email)
│
├── resources/ → Configuración (application.yml, scripts SQL, plantillas)
└── test/java/com/proyecto1/
→ Pruebas unitarias e integraciones (JUnit + Mockito + MockMvc)