package com.microapps.countriesusb.controllers;

// Importaciones necesarias para la funcionalidad del controlador
import com.microapps.countriesusb.entities.CountriesEntity; // Entidad que representa la tabla de países en la base de datos
import com.microapps.countriesusb.services.CountriesService; // Servicio que maneja la lógica de negocio relacionada con los países
import org.springframework.http.ResponseEntity; // Permite personalizar la respuesta HTTP con códigos de estado y contenido
import org.springframework.web.bind.annotation.*; // Contiene anotaciones para definir controladores y endpoints
import java.util.List; // Importación necesaria para manejar listas de objetos

// Anotación que indica que esta clase es un controlador REST que maneja solicitudes HTTP y devuelve respuestas JSON
@RestController
// Define la ruta base para todos los endpoints de este controlador
@RequestMapping("/api/v1/countries")
public class CountriesController {

    // Declaración del servicio de países como una dependencia
    private final CountriesService countriesService;

    // Inyección de dependencia del servicio a través del constructor
    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    /**
     * Endpoint para obtener la lista de todos los países.
     * @return Lista de objetos CountriesEntity en formato JSON.
     */
    @GetMapping
    public List<CountriesEntity> getAllCountries() {
        return countriesService.getAllCountries(); // Llama al servicio para obtener la lista de países
    }

    /**
     * Endpoint para obtener un país específico por su ID.
     * @param id Identificador único del país a buscar.
     * @return Un objeto ResponseEntity con la información del país o un mensaje de error si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCountry(@PathVariable Long id) {
        return countriesService.getCountriesById(id); // Llama al servicio para obtener el país por su ID
    }

    /**
     * Endpoint para crear un nuevo país.
     * @param paisACrearse Objeto JSON que representa al nuevo país a crear.
     * @return ResponseEntity con la respuesta del servicio y el país creado.
     */
    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody CountriesEntity paisACrearse) {
        return countriesService.addCountry(paisACrearse); // Llama al servicio para agregar un nuevo país
    }

    /**
     * Endpoint para actualizar un país existente.
     * @param id Identificador del país que se desea actualizar.
     * @param paisAActualizar Objeto JSON con los datos actualizados del país.
     * @return ResponseEntity con el país actualizado o un mensaje de error si el país no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable Long id, @RequestBody CountriesEntity paisAActualizar) {
        return countriesService.updateCountry(id, paisAActualizar); // Llama al servicio para actualizar los datos del país
    }

    /**
     * Endpoint para eliminar un país por su ID.
     * @param id Identificador único del país a eliminar.
     * @return ResponseEntity con un mensaje de éxito o un error si el país no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
        return countriesService.deleteCountryById(id); // Llama al servicio para eliminar el país de la base de datos
    }
}
