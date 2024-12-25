# Proyecto de Horóscopo con Login

## Descripción

Este proyecto es una aplicación web simple para consultar el horóscopo chino basado en el año de nacimiento del usuario. Incluye funcionalidades de login, registro y gestión de usuarios.

## Tecnologías Utilizadas

* **Java 21**: Lenguaje de programación principal.
* **Tomcat 11.0.1**: Servidor web para la aplicación.
* **Base de datos MySQL**: Para almacenar información de usuarios y horóscopos.
* **Servlets y JSP**: Para el manejo de lógica de negocio y vistas.
* **Archivo .env**: Para la configuración de variables de entorno sensibles.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

* **Java 21**
* **Apache Tomcat 11.0.1**
* **MySQL o un sistema compatible**: Para la base de datos.
* **Un IDE compatible**: Como IntelliJ IDEA o Eclipse.

## Configuración

### 1. Configuración del Archivo .env

El archivo .env se encuentra en la ruta [src/main/resources](cci:7://file:///C:/Users/Claud/IdeaProjects/estudioMod5/horoscopo/src/main/resources:0:0-0:0) y contiene configuraciones esenciales para la conexión con la base de datos. Un ejemplo del contenido del archivo es:
```ENV
DB_URL=jdbc:mysql://localhost:3306/bd_prueba
DB_USER=tu_usuario
DB_PASSWORD=tu_contraseña
```
### 2. Base de Datos
   El contenido de la base de datos se encuentra en el archivo ```db.sql``` en la raíz del proyecto. Este archivo contiene las instrucciones SQL necesarias para crear y poblar la base de datos.

## Estructura del Proyecto

- **src/main/java/org.example.horoscopo**: Contiene las clases principales del proyecto.
   - `dto`: Objetos de transferencia de datos.
   - `service`: Lógica de negocio.
   - `repository`: Acceso a la base de datos.
   - `servlets`: Controladores para las solicitudes HTTP.



- **webapp**: Archivos JSP para la interfaz de usuario.

- **db.sql**: Script para crear y poblar la base de datos.

---

## Autor

Claudio Cabrera