# ForoHub
## Descripción
Este proyecto forma parte de los challenge del programa ONE de Oracle. Este proyecto corresponde al ultimo challenge de la formacion Backend de Alura | One
## Características
La plataforma se enfoca en los temas de discusión y permite realizar las operaciones CRUD: Crear, Consultar, Actualizar y Eliminar temas.
Los datos se almacenan en una base de datos relacional llamada foro_tech para garantizar la persistencia de la información. Las tablas incluidas son: Temas, Respuestas, Cursos, Usuarios.
Se utiliza la autenticación JWT (JSON Web Token) para verificar la identidad de los usuarios mediante correo y contraseña, los cuales se encuentran registrados en la base de datos de usuarios.
Se aplican validaciones de negocio para evitar solicitudes con campos vacíos y para impedir el registro de temas duplicados con el mismo título y mensaje.
Se siguen las mejores prácticas de desarrollo y se adopta el principio SOLID, lo que facilita la incorporación de nuevas funcionalidades en Foro Tech.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3.0
- Spring Data JPA
- Hibernate
- Maven
- Lombok

## Dependencias
- spring-boot-starter-data-jpa: Integración de JPA con Spring Boot.
- spring-boot-starter-security: Seguridad y autenticación.
- spring-boot-starter-validation: Validación de datos.
- spring-boot-starter-web: Creación de aplicaciones web, incluyendo servicios RESTful.
- flyway-core y flyway-mysql: Migración y gestión de la base de datos.
- spring-boot-devtools: Facilita el desarrollo con reinicio automático.
- mysql-connector-java: Conexión con la base de datos MySQL.
- lombok: Reduce el código boilerplate.
- spring-boot-starter-test: Pruebas unitarias e de integración.
- spring-security-test: Pruebas de seguridad.
- java-jwt: Trabajo con JSON Web Tokens.

## Instalación y Ejecución

### Clonar el repositorio:
```
git clone https://github.com/miguelalanis/forohub
```
### Navegar al directorio del proyecto:
```
cd forohub
```
Configurar las propiedades de la base de datos en application.properties.

Ejecutar la aplicación.
