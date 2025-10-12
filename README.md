## 🗂️ Estructura del proyecto

El backend está organizado bajo una arquitectura **modular por dominio**, siguiendo el patrón **Controller–Service–Repository** de Spring Boot.

```bash
PROYECTO1/
├── pom.xml                              # Configuración de dependencias Maven
├── mvnw / mvnw.cmd                      # Ejecutores Maven (Linux / Windows)
├── .gitignore                           # Archivos ignorados por Git
├── .gitattributes                       # Normalización de texto en Git
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/proyecto1/
│   │   │       ├── Proyecto1Application.java     # Clase principal (Spring Boot)
│   │   │
│   │   │       ├── config/                      # ⚙️ Configuración global
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   ├── JwtAuthenticationFilter.java
│   │   │       │   ├── SwaggerConfig.java
│   │   │       │   ├── MailConfig.java
│   │   │       │   └── RedisConfig.java
│   │   │
│   │   │       ├── exception/                   # 🚨 Manejo de errores
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   ├── UserAlreadyExistsException.java
│   │   │       │   ├── EventNotFoundException.java
│   │   │       │   ├── InvalidQRCodeException.java
│   │   │       │   └── NotificationSendingException.java
│   │   │
│   │   │       ├── common/                      # 🧩 Clases compartidas
│   │   │       │   ├── enums/
│   │   │       │   │   ├── Role.java
│   │   │       │   │   ├── EventStatus.java
│   │   │       │   │   ├── RegistrationStatus.java
│   │   │       │   │   ├── CheckInMethod.java
│   │   │       │   │   └── GroupRole.java
│   │   │       │   ├── dto/
│   │   │       │   │   └── ApiResponse.java
│   │   │       │   ├── util/
│   │   │       │   │   ├── EmailUtil.java
│   │   │       │   │   ├── QRGeneratorUtil.java
│   │   │       │   │   └── DateUtils.java
│   │   │       │   └── constants/
│   │   │       │       └── AppConstants.java
│   │   │
│   │   │       ├── auth/                        # 🔐 Autenticación y usuarios
│   │   │       │   ├── controller/
│   │   │       │   │   ├── AuthController.java
│   │   │       │   │   └── UserController.java
│   │   │       │   ├── entity/
│   │   │       │   │   └── User.java
│   │   │       │   ├── dto/
│   │   │       │   │   ├── LoginRequest.java
│   │   │       │   │   ├── RegisterRequest.java
│   │   │       │   │   ├── AuthResponse.java
│   │   │       │   │   └── UserProfileResponse.java
│   │   │       │   ├── repository/
│   │   │       │   │   └── UserRepository.java
│   │   │       │   ├── service/
│   │   │       │   │   ├── AuthService.java
│   │   │       │   │   └── UserService.java
│   │   │       │   └── service/impl/
│   │   │       │       ├── AuthServiceImpl.java
│   │   │       │       └── UserServiceImpl.java
│   │   │
│   │   │       ├── event/                       # 🎫 Eventos y categorías
│   │   │       │   ├── controller/
│   │   │       │   │   └── EventController.java
│   │   │       │   ├── entity/
│   │   │       │   │   ├── Event.java
│   │   │       │   │   ├── Category.java
│   │   │       │   │   └── Location.java
│   │   │       │   ├── dto/
│   │   │       │   │   ├── EventRequest.java
│   │   │       │   │   ├── EventResponse.java
│   │   │       │   │   └── CategoryDTO.java
│   │   │       │   ├── repository/
│   │   │       │   │   ├── EventRepository.java
│   │   │       │   │   └── CategoryRepository.java
│   │   │       │   ├── service/
│   │   │       │   │   ├── EventService.java
│   │   │       │   │   └── CategoryService.java
│   │   │       │   └── service/impl/
│   │   │       │       ├── EventServiceImpl.java
│   │   │       │       └── CategoryServiceImpl.java
│   │   │
│   │   │       ├── registration/                # 📝 Registros de eventos
│   │   │       │   ├── controller/RegistrationController.java
│   │   │       │   ├── entity/Registration.java
│   │   │       │   ├── repository/RegistrationRepository.java
│   │   │       │   ├── service/RegistrationService.java
│   │   │       │   └── service/impl/RegistrationServiceImpl.java
│   │   │
│   │   │       ├── group/                       # 💬 Grupos y chat
│   │   │       │   ├── controller/GroupController.java
│   │   │       │   ├── entity/
│   │   │       │   │   ├── UserGroup.java
│   │   │       │   │   ├── GroupMember.java
│   │   │       │   │   └── GroupMessage.java
│   │   │       │   ├── repository/
│   │   │       │   │   ├── GroupRepository.java
│   │   │       │   │   ├── GroupMemberRepository.java
│   │   │       │   │   └── GroupMessageRepository.java
│   │   │       │   ├── service/GroupService.java
│   │   │       │   └── service/impl/GroupServiceImpl.java
│   │   │
│   │   │       ├── attendance/                  # 🕓 Asistencia
│   │   │       │   ├── controller/AttendanceController.java
│   │   │       │   ├── entity/AttendanceLog.java
│   │   │       │   ├── repository/AttendanceRepository.java
│   │   │       │   ├── service/AttendanceService.java
│   │   │       │   └── service/impl/AttendanceServiceImpl.java
│   │   │
│   │   │       ├── notification/                # 🔔 Notificaciones
│   │   │       │   ├── controller/NotificationController.java
│   │   │       │   ├── entity/Notification.java
│   │   │       │   ├── repository/NotificationRepository.java
│   │   │       │   ├── service/NotificationService.java
│   │   │       │   └── service/impl/NotificationServiceImpl.java
│   │   │
│   │   └── resources/
│   │       ├── application.yml                 # Configuración general
│   │       ├── schema.sql                     # Creación de tablas (opcional)
│   │       ├── data.sql                       # Datos iniciales (opcional)
│   │       └── banner.txt                     # Mensaje al iniciar la app
│   │
│   └── test/
│       └── java/com/proyecto1/
│           ├── attendance/AttendanceServiceTest.java
│           ├── auth/AuthControllerTest.java
│           ├── event/EventServiceTest.java
│           ├── notification/NotificationServiceTest.java
│           └── Proyecto1ApplicationTests.java
│
└── README.md


```

