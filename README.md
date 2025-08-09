# Catálogo de Libros Interactivo

<div align="center">

[![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.3-green?style=for-the-badge&logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue?style=for-the-badge&logo=postgresql)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-gray?style=for-the-badge&logo=docker)](https://www.docker.com/)


</div>

Este proyecto es una aplicación de consola para catalogar libros, desarrollada en Java con el framework Spring Boot. El programa interactúa con la API pública de Gutendex para buscar y almacenar información sobre libros y autores en una base de datos PostgreSQL. El entorno completo está contenerizado con Docker para simplificar su ejecución.

---

## Tabla de Contenidos

* [Descripción](#descripción)
* [Funcionalidades](#funcionalidades)
* [Arquitectura](#arquitectura)
* [Tecnologías Utilizadas](#tecnologías-utilizadas)
* [Instalación y Ejecución](#instalación-y-ejecución)
    * [Prerrequisitos](#prerrequisitos)
    * [Pasos de Ejecución](#pasos-de-ejecución)
    * [Comandos de Docker](#comandos-de-docker)
* [Estructura del Proyecto](#estructura-del-proyecto)
* [Contribuciones](#contribuciones)


---

## Descripción

La aplicación permite a los usuarios construir y gestionar un catálogo de libros personal a través de una interfaz de línea de comandos. Las búsquedas de libros se realizan contra la API de Gutendex, y los resultados se pueden persistir en la base de datos local para consultas posteriores.

---


##  Funcionalidades

La aplicación ofrece un menú interactivo en consola con diversas opciones para gestionar y consultar el catálogo de libros.

### 1.  Búsqueda de Libros por Título
- **Descripción:** Permite al usuario buscar un libro en la API de **Gutendex** introduciendo su título.
- **Funcionamiento:**
  - Se realiza una consulta HTTP a la API con el título proporcionado.
  - Si el libro ya existe en la base de datos local, se notifica al usuario para evitar duplicados.
  - Si no existe, se guarda automáticamente junto con su información (autor, idioma, número de descargas, etc.).

---

### 2.  Listar Libros Registrados
- **Descripción:** Muestra todos los libros almacenados en la base de datos local.
- **Información mostrada:**
- Título
- Autor(es)
- Idioma
- Número de descargas

---

### 3.  Listar Autores Registrados
- **Descripción:** Presenta una lista de todos los autores guardados en la base de datos.
- **Información mostrada:**
- Nombre del autor
- Año de nacimiento
- Año de fallecimiento (si aplica)

---

### 4.  Listar Autores Vivos por Año
- **Descripción:** Filtra y muestra los autores que estaban vivos en un año específico ingresado por el usuario.
- **Funcionamiento:**
- El usuario introduce un año (por ejemplo, 1800).
- El sistema busca todos los autores cuyo año de nacimiento sea anterior o igual a ese año y cuyo año de fallecimiento sea posterior o nulo.

---

### 5.  Listar Libros por Idioma
- **Descripción:** Permite filtrar los libros registrados según el idioma de su publicación.
- **Idiomas soportados:**  
- `es` → Español  
- `en` → Inglés  
- `fr` → Francés  
- `pt` → Portugués


---

## Arquitectura

El proyecto está diseñado siguiendo una arquitectura en capas para separar las responsabilidades del código.

* **Capa de Presentación (`principal`)**: Contiene la clase `Principal`, que maneja la interfaz de usuario de la consola, el menú de opciones y la interacción directa con el usuario.
* **Capa de Servicio (`service`)**: Implementa la lógica de negocio. Las clases `LibroService` y `AutorService` orquestan las operaciones, como procesar los datos de la API y coordinar con la capa de repositorio.
* **Capa de Acceso a Datos (`repository`)**: Se encarga de la persistencia. Las interfaces `LibroRepository` y `AutorRepository` extienden de `JpaRepository` para interactuar con la base de datos.
* **Capa de Modelo (`model`)**: Define las entidades de datos. Las clases `Libro` y `Autor` son las entidades JPA que mapean las tablas de la base de datos.

---

## Tecnologías Utilizadas

* **Java 17**: Lenguaje de programación base.
* **Spring Boot 3.2.3**: Framework para el desarrollo de la aplicación.
* **Spring Data JPA**: Para la capa de persistencia y la interacción con la base de datos.
* **PostgreSQL 14**: Sistema de gestión de bases de datos relacional.
* **API de Gutendex**: Fuente externa para los datos de los libros.
* **Docker y Docker Compose**: Para la contenerización y gestión del entorno de la aplicación.

---

## ⚙️ Instalación y Ejecución

El proyecto está dockerizado para facilitar su configuración y despliegue.

### Prerrequisitos

* **Docker**
* **Git**

### Pasos de Ejecución

1.  **Clona el repositorio:**
    ````bash
    git clone https://github.com/ericks97/CatalogoLibros.git
    cd nombre-del-repositorio
    ````

2.  **Crea el archivo de variables de entorno:**
    El archivo **`.env`** es ignorado por Git por seguridad, por lo que necesitas crearlo manualmente. En la raíz del proyecto, crea un nuevo archivo llamado **`.env`** y añade el siguiente contenido. Estos son los valores que usará Docker Compose para configurar la base de datos.
    ````env
    # Credenciales para la base de datos PostgreSQL
    POSTGRES_USER=postgres
    POSTGRES_PASSWORD=postgres
    ````

3.  **Construye y ejecuta la aplicación:**
    Desde el directorio raíz del proyecto, ejecuta el siguiente comando:
    ````bash
    docker-compose up --build
    ````
    Este comando construirá la imagen de la aplicación e iniciará los contenedores necesarios.

4.  **Interactúa con la aplicación:**
    La consola interactiva se iniciará en la terminal donde ejecutaste el comando.

---
### Comandos Útiles de Docker

* **Ver contenedores activos:** `docker ps`
* **Ver logs de la aplicación:** `docker logs java_app`
* **Detener contenedores:** `docker-compose down`
* **Detener y eliminar volúmenes:** `docker-compose down -v`
---

## Estructura del Proyecto

```
.
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── proyecto/
│                   └── catalogo/
│                       ├── CatalogoDeLibrosApplication.java
│                       ├── principal/
│                       ├── model/
│                       ├── repository/
│                       └── service/
├── resources/
│   ├── application.properties
│   └── application-docker.properties
├── docker-compose.yaml
├── Dockerfile
└── README.md
```

---

## Contribuciones

Las contribuciones son bienvenidas. Para sugerir mejoras o reportar errores, por favor, abre un *issue* o envía un *pull request*.

---
