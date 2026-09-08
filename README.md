## 🚀 Tecnologías Utilizadas

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3.3.3 (Web, Data JPA)
* **Base de Datos:** MySQL
* **Documentación:** OpenAPI 3 / Swagger UI (`springdoc-openapi`)
* **Pruebas:** JUnit 5 + Mockito

---

## 🏛️ Canales BFF Implementados

El sistema expone tres capas adaptadas a distintos clientes:

1. **Canal Web (`/api/v1/bff/web/dashboard/{numeroCuenta}`)**
   * Retorna la vista completa del cliente: saldo actual e historial completo de transacciones.
2. **Canal Móvil (`/api/v1/bff/mobile/summary/{numeroCuenta}`)**
   * Retorna una respuesta liviana adaptada a dispositivos móviles: saldo disponible y únicamente las últimas 5 transacciones.
3. **Canal Cajero / ATM (`/api/v1/bff/atm/saldo/{numeroCuenta}`)**
   * Retorna una respuesta operacional rápida: saldo restante y estado de la operación.

---

## 🛠️ Instrucciones de Configuración y Ejecución

1. **Base de Datos:**
   * Asegurar que MySQL esté ejecutándose en el puerto `3306`.
   * Ejecutar el archivo `script.sql` incluido en la raíz para poblar la base de datos `banco_xyz`.

2. **Ejecución de la Aplicación:**
   * Abrir el proyecto en VS Code / IntelliJ.
   * Ejecutar la clase principal `BancoApplication.java`.
   * El servidor iniciará en `http://localhost:8080`.

3. **Documentación Swagger UI:**
   * Acceder a la interfaz interactiva en:  
     `http://localhost:8080/swagger-ui/index.html`