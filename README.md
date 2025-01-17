# Foro Hub - API REST

## Descripción

**Foro Hub** es una API REST que replica el funcionamiento básico de un foro de discusión en línea, específicamente centrada en la gestión de tópicos. Los usuarios pueden crear, visualizar, actualizar y eliminar tópicos, interactuando con la plataforma de manera eficiente. Esta API está desarrollada utilizando el framework **Spring** y permite el manejo de información de manera persistente mediante una base de datos.

En este proyecto, replicamos el flujo de operaciones típicas de un foro de preguntas y respuestas, como los utilizados en plataformas de aprendizaje, permitiendo a los usuarios gestionar temas de discusión y colaborar entre sí.

## Funcionalidades

La API REST proporciona las siguientes funcionalidades:

- **Crear un nuevo tópico**: Los usuarios pueden crear nuevos tópicos de discusión.
- **Mostrar todos los tópicos**: Obtén una lista con todos los tópicos creados.
- **Mostrar un tópico específico**: Obtén la información detallada de un tópico específico.
- **Actualizar un tópico**: Permite a los usuarios modificar los detalles de un tópico existente.
- **Eliminar un tópico**: Elimina un tópico de la base de datos.

Esto sigue el modelo **CRUD (Create, Read, Update, Delete)**, aplicando buenas prácticas de desarrollo con el framework **Spring** para crear una API robusta y funcional.

## Características

- **Rutas RESTful**: La API sigue las mejores prácticas para rutas REST, facilitando la integración y uso de la plataforma.
- **Validaciones de negocio**: Las operaciones se validan de acuerdo con las reglas del foro.
- **Persistencia de datos**: La información se guarda en una base de datos para asegurar la persistencia.
- **Autenticación y autorización**: Implementación de seguridad para restringir el acceso a la información según el rol de usuario.

## Tecnologías

- **Spring Framework**: Para la construcción de la API REST.
- **Base de datos (MySQL/PostgreSQL/SQLite)**: Para la persistencia de datos de tópicos y usuarios.
- **JWT (JSON Web Tokens)**: Para la autenticación y autorización de usuarios.

## Requisitos

- **Java 11 o superior**.
- **Spring Boot**.
- **Base de datos** (configuración de base de datos específica como MySQL, PostgreSQL o SQLite).
- **Postman o herramienta similar** para probar las rutas de la API.

## Instalación

1. **Clona el repositorio:**

```bash
git clone https://github.com/tu-usuario/foro-hub.git
