Tecnologías
Java 17, Spring Boot 3 (Web, Data JPA, Security), MySQL/MariaDB, JWT (JSON Web Token), Maven.
Requisitos Previos
1. Instalar Java 17+, Maven y MySQL.
2. Ejecutar el script gemini_ambiental_DB.sql en MySQL.
3. Crear la tabla 'usuario' si no existe en la base de datos.
Configuración
En src/main/resources/application.properties configurar la conexión a MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/gemini_ambiental_DB?useSSL=false&serverTimezo
ne;=UTC
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
jwt.secret=SecretoSeguro
jwt.expiration=3600000
Ejecución
Compilar y ejecutar con: mvn spring-boot:run
La API queda disponible en: http://localhost:8080/api
Endpoints de Autenticación
POST /api/auth/login - Permite iniciar sesión con username y password, devuelve un token JWT.
POST /api/auth/register - Permite registrar un nuevo usuario vinculado a una persona.
Endpoints de Personas
GET /api/personas - Lista todas las personas (requiere JWT).
GET /api/personas/{dni} - Obtiene una persona por DNI.
POST /api/personas - Crea una nueva persona.
PUT /api/personas/{dni} - Actualiza una persona existente.
DELETE /api/personas/{dni} - Elimina una persona por DNI.
Seguridad
Los endpoints de /api/auth/** son públicos, mientras que los de /api/personas/** requieren un token
JWT válido. Las contraseñas se almacenan encriptadas con BCrypt y los tokens incluyen roles
(ROLE_USER, ROLE_ADMIN).
