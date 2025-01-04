# Task Manager

## Descripción General
Este proyecto implementa un sistema básico de gestión de tareas en Java, diseñado para permitir a los usuarios crear, organizar y priorizar tareas. El sistema utiliza principios de diseño orientado a objetos, estructuras de datos, y programación funcional.

## Características

### Estructuras de Datos
- Uso de listas enlazadas para almacenar las tareas.
- Cada tarea incluye:
  - Identificador único.
  - Título.
  - Descripción.
  - Prioridad (ALTA, MEDIA, BAJA).
  - Estado (PENDIENTE, EN PROGRESO, COMPLETADA).

### Operaciones Principales
1. **Agregar tarea**: Permite crear y agregar una nueva tarea.
2. **Editar tarea**: Modifica los detalles de una tarea existente.
3. **Eliminar tarea**: Elimina una tarea por su identificador único.
4. **Listar tareas**: Muestra todas las tareas organizadas por prioridad.
5. **Buscar tarea**: Busca tareas por título o descripción usando Streams.

### Programación Funcional
- Uso de expresiones lambda para filtrar tareas por estado.
- Uso de Streams para ordenar tareas por prioridad y realizar búsquedas.

### Diseño Orientado a Objetos
- Principios SOLID aplicados:
  - **Responsabilidad única**: Clases bien definidas para manejar tareas y su gestión.
  - **Abierto/Cerrado**: Fácil de extender sin modificar código existente.
- Clases principales:
  - `Task`: Representa las tareas individuales.
  - `TaskManager`: Gestiona las operaciones sobre las tareas.

## Estructura del Código

### Clases Principales
- **Task**: Contiene los atributos y métodos relacionados con las tareas.
- **TaskManager**: Implementa la lógica para agregar, editar, eliminar, listar y buscar tareas.

### Menú de Consola
Un menú interactivo permite realizar las siguientes acciones:
- Agregar tarea
- Editar tarea
- Eliminar tarea
- Listar tareas
- Buscar tarea
- Salir del sistema

### Pruebas Unitarias
Se incluyen pruebas unitarias con JUnit para validar las operaciones principales:
- Creación de tareas.
- Edición y eliminación de tareas.

## Requisitos
- **Java 8 o superior**.
- Biblioteca JUnit para las pruebas unitarias.

## Ejecución
1. Clona el repositorio.
2. Compila y ejecuta el proyecto desde tu IDE o consola.
3. Interactúa con el menú en consola para gestionar las tareas.

## Contribuciones
¡Contribuciones son bienvenidas! Si tienes ideas para mejorar este sistema, por favor crea un issue o un pull request.
