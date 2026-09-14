# Banco XYZ - Arquitectura Backend for Frontend (BFF)

Este proyecto corresponde a la evaluación sumativa de la Semana 5 para la asignatura **Desarrollo Backend III (PBY2203)**. Implementa el patrón arquitectónico **Backend for Frontend (BFF)** sobre **Java Spring Boot**, optimizando y personalizando las respuestas para tres canales de atención independientes (Web, Mobile y Cajeros Automáticos).

---

## Objetivo del Proyecto

Proporcionar APIs personalizadas y desacopladas para cada canal cliente del Banco XYZ, garantizando optimización de payloads (DTOs a la medida) y restringiendo el acceso mediante seguridad por canal (Spring Security) y propuesta de cifrado HTTPS.

---

## Estructura del Código

El proyecto sigue una organización modular limpia dentro del paquete `com.duoc.banco`:

src/main/java/com/duoc/banco/
├── bff/                  # Controladores BFF por canal (Web, Mobile, ATM)
├── config/               # Configuración de Spring Security y Roles
├── exception/            # Manejo global de excepciones (GlobalExceptionHandler)
├── model/                # Entidades JPA (Cuenta, Transaccion)
├── repository/           # Interfaces de acceso a datos (Spring Data JPA)
└── service/              # Lógica de negocio e integración de datos

---

## Seguridad y Autenticación por Canal

Se implementó **Spring Security con HTTP Basic Auth**. Cada endpoint está protegido y requiere credenciales vinculadas a un rol específico (`ROLE_WEB`, `ROLE_MOBILE`, `ROLE_ATM`), impidiendo el consumo cruzado no autorizado entre plataformas.

### Credenciales de Prueba

| Canal | Usuario | Contraseña | Rol Asignado |
| :--- | :--- | :--- | :--- |
| **BFF Web** | `user_web` | `web123` | `ROLE_WEB` |
| **BFF Mobile** | `user_mobile` | `mobile123` | `ROLE_MOBILE` |
| **BFF ATM** | `user_atm` | `atm123` | `ROLE_ATM` |

---

## Endpoints Disponibles

| Canal | Método | Ruta del Endpoint | Descripción del Payload |
| :--- | :--- | :--- | :--- |
| **Web** | `GET` | `/api/v1/bff/web/dashboard/{numeroCuenta}` | Respuesta extendida con saldo e historial completo. |
| **Mobile** | `GET` | `/api/v1/bff/mobile/summary/{numeroCuenta}` | Payload liviano con saldo disponible y últimas 5 transacciones. |
| **ATM** | `GET` | `/api/v1/bff/atm/saldo/{numeroCuenta}` | Respuesta operacional mínima orientada a consultas rápidas. |

---

## Instrucciones de Ejecución

### Requisitos Previos
* JDK 17 o superior instalado.
* MySQL Server en ejecución.

### Pasos para Ejecutar
1. Clonar el repositorio:
   https://github.com/Cibanezl/banco-xyz-bff.git
2. Ejecutar la aplicación mediante Maven Wrapper:
   ./mvnw spring-boot:run
3. Acceder a Swagger UI:
   http://localhost:8080/swagger-ui/index.html
