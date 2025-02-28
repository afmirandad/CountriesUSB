Proyecto: API de Gestión de Países con Spring Boot

Descripción del Proyecto

Este proyecto es una API REST desarrollada con Spring Boot, diseñada para gestionar información sobre países. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una lista de países en memoria, proporcionando endpoints estructurados según buenas prácticas de desarrollo.

El proyecto utiliza Spring Boot, que facilita la creación de aplicaciones empresariales con menos configuración y un enfoque modular. Se han implementado las anotaciones propias de Spring para definir el controlador, servicio y las entidades, asegurando un código limpio y mantenible.

Tecnologías Utilizadas

Java 17

Spring Boot 3.x

Lombok (para reducir código boilerplate en las entidades)

Java Streams y Optional (para manejo eficiente de datos en listas y evitar NullPointerException)

Explicación de Optional en Java

El uso de Optional<T> en el proyecto permite evitar valores nulos y manejar posibles ausencias de datos de manera segura. Por ejemplo, en la búsqueda de países por ID, se usa Optional para verificar si el país existe antes de retornar una respuesta:

public ResponseEntity<?> getCountriesById(Long id) {
Optional<CountriesEntity> country = countries.stream()
.filter(c -> c.getId().equals(id))
.findFirst();

    return country.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().body(Map.of("error", "País con ID " + id + " no encontrado")));
}

Con Optional, evitamos la necesidad de comprobaciones manuales de null, mejorando la legibilidad y seguridad del código.

Explicación de las Anotaciones de Spring Boot Utilizadas

@RestController

Define una clase como un controlador REST, permitiendo manejar peticiones HTTP y devolver respuestas JSON.

@RequestMapping("/api/v1/countries")

Asigna una ruta base a todos los endpoints dentro del controlador, en este caso, "/api/v1/countries".

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping

Definen los métodos HTTP para las operaciones CRUD:

``: Para obtener información.

``: Para agregar nuevos datos.

``: Para actualizar datos existentes.

``: Para eliminar registros.

@Service

Marca una clase como un servicio de negocio, indicando que contiene la lógica de la aplicación y será gestionada por el contenedor de Spring.

@PathVariable

Vincula un parámetro de la URL con una variable dentro del método, permitiendo capturar valores dinámicos de la ruta.

@RequestBody

Convierte automáticamente un objeto JSON recibido en una instancia de una entidad Java.

Patrón de Diseño Utilizado

El proyecto sigue el patrón MVC (Modelo-Vista-Controlador), separando las responsabilidades en:

Modelo (Entities): Representado por la clase CountriesEntity, que define la estructura de los datos.

Vista: No aplica en este proyecto ya que es solo una API, pero el cliente (frontend o sistema externo) consumiría los datos JSON devueltos.

Controlador (``): Maneja las peticiones HTTP y delega la lógica al servicio.

Servicio (``): Contiene la lógica de negocio y manipulación de los datos.

Importancia de Spring Boot en el Desarrollo de Aplicaciones

Spring Boot es un framework altamente eficiente para desarrollar aplicaciones Java empresariales, ya que proporciona:

Configuración automática con Spring Boot Starter Packs.

Gestión de dependencias simplificada mediante Maven o Gradle.

Integración con bases de datos y herramientas de seguridad.

Arquitectura modular, permitiendo agregar componentes como Spring Security, Spring Data JPA, etc.

Capacidad para construir microservicios escalables con facilidad.

En este proyecto, Spring Boot ha permitido desarrollar una API REST de forma rápida, con una estructura clara y reutilizable.

Endpoints Disponibles

Obtener todos los países

GET /api/v1/countries

Obtener un país por ID

GET /api/v1/countries/{id}

Agregar un nuevo país

POST /api/v1/countries
Body:
{
"countryName": "España",
"countryCapital": "Madrid",
"countryContinent": "Europa",
"countryCode": "34"
}

Actualizar un país por ID

PUT /api/v1/countries/{id}
Body:
{
"countryName": "España",
"countryCapital": "Madrid",
"countryContinent": "Europa",
"countryCode": "34"
}

Eliminar un país por ID

DELETE /api/v1/countries/{id}

Conclusión

Este proyecto demuestra cómo utilizar Spring Boot para construir una API REST con una estructura organizada, aplicando buenas prácticas en la gestión de datos, el uso de Optional, y el patrón MVC. Es fácilmente escalable y adaptable para integrar una base de datos en el futuro.