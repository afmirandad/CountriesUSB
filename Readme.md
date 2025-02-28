API de Gestión de Países con Spring Boot 🌍
Descripción del Proyecto

Este proyecto es una API REST desarrollada con Spring Boot, diseñada para gestionar información sobre países. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una lista de países en memoria, proporcionando endpoints estructurados según buenas prácticas de desarrollo.

Spring Boot facilita la creación de aplicaciones empresariales con menos configuración y un enfoque modular, lo que permite a los desarrolladores centrarse en la lógica del negocio sin preocuparse por la infraestructura. Este proyecto utiliza anotaciones propias de Spring para definir controladores, servicios y entidades, asegurando un código limpio y fácil de mantener.
Tecnologías Utilizadas

    Java 17 ☕
    Spring Boot 3.x 🚀
    Lombok (para reducir el código boilerplate en las entidades) 🔧
    Java Streams y Optional (para manejo eficiente de datos en listas y evitar NullPointerExceptions) 📊

Explicación de Optional en Java

El uso de Optional<T> en el proyecto permite evitar valores nulos y manejar posibles ausencias de datos de manera segura. Un ejemplo práctico de su uso sería en la búsqueda de países por ID:

java

public ResponseEntity<?> getCountriesById(Long id) {
    Optional<CountriesEntity> country = countries.stream()
        .filter(c -> c.getId().equals(id))
        .findFirst();

    return country.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().body(Map.of("error", "País con ID " + id + " no encontrado")));
}

De esta manera, evitamos la necesidad de comprobaciones manuales de null, mejorando la legibilidad y seguridad del código.
Explicación de las Anotaciones de Spring Boot Utilizadas
@RestController

Define una clase como un controlador REST, permitiendo manejar peticiones HTTP y devolver respuestas en formato JSON.
@RequestMapping("/api/v1/countries")

Asigna una ruta base a todos los endpoints dentro del controlador, en este caso, /api/v1/countries.
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping

Definen los métodos HTTP para las operaciones CRUD:

    @GetMapping: Para obtener información.
    @PostMapping: Para agregar nuevos datos.
    @PutMapping: Para actualizar datos existentes.
    @DeleteMapping: Para eliminar registros.

@Service

Marca una clase como un servicio de negocio, indicando que contiene la lógica de la aplicación y será gestionada por el contenedor de Spring.
@PathVariable

Vincula un parámetro de la URL con una variable dentro del método, permitiendo capturar valores dinámicos de la ruta.
@RequestBody

Convierte automáticamente un objeto JSON recibido en una instancia de una entidad Java.
Patrones de Diseño Utilizados

Este proyecto sigue el patrón MVC (Modelo-Vista-Controlador), separando las responsabilidades en:

    Modelo (Entities): Representado por la clase CountriesEntity, que define la estructura de los datos.
    Vista: No aplica en este proyecto, ya que es una API. El cliente (frontend o sistema externo) consumirá los datos JSON devueltos.
    Controlador: Maneja las peticiones HTTP y delega la lógica al servicio.
    Servicio: Contiene la lógica de negocio y manipulación de los datos.

Importancia de Spring Boot en el Desarrollo de Aplicaciones

Spring Boot es un framework altamente eficiente para desarrollar aplicaciones Java empresariales. Sus principales ventajas incluyen:

    Configuración automática con Spring Boot Starter Packs.
    Gestión de dependencias simplificada mediante Maven o Gradle.
    Integración con bases de datos y herramientas de seguridad.
    Arquitectura modular, permitiendo agregar componentes como Spring Security, Spring Data JPA, etc.
    Capacidad para construir microservicios escalables con facilidad.

En este proyecto, Spring Boot ha permitido desarrollar una API REST de forma rápida, con una estructura clara y reutilizable.
Endpoints Disponibles

Aquí están los principales endpoints disponibles en la API:
Obtener todos los países

http

GET /api/v1/countries

Obtener un país por ID

http

GET /api/v1/countries/{id}

Agregar un nuevo país

http

POST /api/v1/countries

Body:

json

{
  "countryName": "España",
  "countryCapital": "Madrid",
  "countryContinent": "Europa",
  "countryCode": "34"
}

Actualizar un país por ID

http

PUT /api/v1/countries/{id}

Body:

json

{
  "countryName": "España",
  "countryCapital": "Madrid",
  "countryContinent": "Europa",
  "countryCode": "34"
}

Eliminar un país por ID

http

DELETE /api/v1/countries/{id}

Conclusión

Este proyecto demuestra cómo utilizar Spring Boot para construir una API REST con una estructura organizada, aplicando buenas prácticas en la gestión de datos, el uso de Optional, y el patrón MVC. La arquitectura modular y escalable permite que el proyecto sea fácilmente adaptable para integrar una base de datos en el futuro, así como extender sus funcionalidades según las necesidades.
