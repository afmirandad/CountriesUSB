package com.microapps.countriesusb.services;

// Importaciones necesarias para la funcionalidad del servicio
import com.microapps.countriesusb.entities.CountriesEntity; // Entidad que representa la tabla de países en la base de datos
import org.springframework.http.ResponseEntity; // Permite personalizar la respuesta HTTP con códigos de estado y contenido
import org.springframework.stereotype.Service; // Anotación que marca esta clase como un servicio gestionado por Spring
import java.util.ArrayList; // Lista dinámica para almacenar países en memoria
import java.util.List; // Importación necesaria para manejar listas de objetos
import java.util.Map; // Permite crear respuestas JSON en formato clave-valor
import java.util.Optional; // Manejo seguro de valores opcionales
import java.util.stream.Collectors; // Para filtrar y transformar listas de países

/**
 * Servicio que maneja la lógica de negocio relacionada con los países.
 */
@Service
public class CountriesService {

    // Lista en memoria que almacena los países
    private final List<CountriesEntity> countries = new ArrayList<>();
    private Long currentId = 1L; // ID autoincremental para los países

    /**
     * Constructor que inicializa la lista con algunos países de prueba.
     */
    public CountriesService() {
        countries.add(new CountriesEntity(currentId++, "Argentina", "Buenos Aires", "América", "AR"));
        countries.add(new CountriesEntity(currentId++, "Colombia", "Bogotá", "América", "57"));
        countries.add(new CountriesEntity(currentId++, "México", "Ciudad de México", "América", "52"));
        countries.add(new CountriesEntity(currentId++, "Perú", "Lima", "América", "51"));
        countries.add(new CountriesEntity(currentId++, "Chile", "Santiago", "América", "56"));
        countries.add(new CountriesEntity(currentId++, "Ecuador", "Quito", "América", "593"));
        countries.add(new CountriesEntity(currentId++, "Uruguay", "Montevideo", "América", "598"));
        countries.add(new CountriesEntity(currentId++, "Paraguay", "Asunción", "América", "595"));
        countries.add(new CountriesEntity(currentId++, "Bolivia", "Sucre", "América", "591"));
        countries.add(new CountriesEntity(currentId++, "Venezuela", "Caracas", "América", "58"));
        countries.add(new CountriesEntity(currentId++, "Costa Rica", "San José", "América", "506"));
        countries.add(new CountriesEntity(currentId++, "Panamá", "Ciudad de Panamá", "América", "507"));
        countries.add(new CountriesEntity(currentId++, "Cuba", "La Habana", "América", "53"));
        countries.add(new CountriesEntity(currentId++, "Guatemala", "Ciudad de Guatemala", "América", "502"));
        countries.add(new CountriesEntity(currentId++, "Honduras", "Tegucigalpa", "América", "504"));
        countries.add(new CountriesEntity(currentId++, "El Salvador", "San Salvador", "América", "503"));
        countries.add(new CountriesEntity(currentId++, "Nicaragua", "Managua", "América", "505"));
        countries.add(new CountriesEntity(currentId++, "Puerto Rico", "San Juan", "América", "1"));
        countries.add(new CountriesEntity(currentId++, "República Dominicana", "Santo Domingo", "América", "1"));
        countries.add(new CountriesEntity(currentId++, "Portugal", "Lisboa", "Europa", "351"));
        countries.add(new CountriesEntity(currentId++, "Reino Unido", "Londres", "Asia", "44"));
        // Se agregan más países...
    }

    /**
     * Obtiene la lista completa de países.
     * @return Lista de objetos CountriesEntity.
     */
    public List<CountriesEntity> getAllCountries() {
        return countries;
    }

    /**
     * Obtiene un país por su ID.
     * @param id Identificador único del país.
     * @return ResponseEntity con el país encontrado o un mensaje de error.
     */
    public ResponseEntity<?> getCountriesById(Long id) {
        Optional<CountriesEntity> country = countries.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        return country.isPresent() ? ResponseEntity.ok(country.get()) :
                ResponseEntity.badRequest().body(Map.of("Error", "País con ID " + id + " no encontrado"));
    }

    /**
     * Filtra los países por continente.
     * @param continent Nombre del continente.
     * @return Lista de países pertenecientes al continente especificado.
     */
    public List<CountriesEntity> getCountriesByContinent(String continent) {
        return countries.stream()
                .filter(c -> c.getCountryContinent().equalsIgnoreCase(continent))
                .collect(Collectors.toList());
    }

    /**
     * Agrega un nuevo país a la lista.
     * @param country País a agregar.
     * @return ResponseEntity con mensaje de éxito o error si el país ya existe.
     */
    public ResponseEntity<?> addCountry(CountriesEntity country) {
        boolean exists = countries.stream()
                .anyMatch(c -> c.getId() == country.getId());

        if (exists) {
            return ResponseEntity.badRequest().body(Map.of("Error", "El país con ID " + country.getId() + " ya existe"));
        }
        country.setId(currentId++);
        countries.add(country);
        return ResponseEntity.ok(Map.of("Mensaje", "País agregado exitosamente", "pais", country));
    }

    /**
     * Actualiza un país existente en la lista.
     * @param id Identificador único del país a actualizar.
     * @param country Datos actualizados del país.
     * @return ResponseEntity con mensaje de éxito o error si el país no existe.
     */
    public ResponseEntity<?> updateCountry(Long id, CountriesEntity country) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getId() == id) {
                country.setId(id);
                countries.set(i, country);
                return ResponseEntity.ok(Map.of("Mensaje", "País actualizado exitosamente", "pais", country));
            }
        }
        return ResponseEntity.badRequest().body(Map.of("Error", "El país con ID " + id + " no existe"));
    }

    /**
     * Elimina un país de la lista por su ID.
     * @param id Identificador único del país a eliminar.
     * @return ResponseEntity con mensaje de éxito o error si el país no se encuentra.
     */
    public ResponseEntity<?> deleteCountryById(Long id) {
        Optional<CountriesEntity> countryToRemove = countries.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (countryToRemove.isPresent()) {
            countries.remove(countryToRemove.get());
            return ResponseEntity.ok(Map.of("Mensaje", "País eliminado exitosamente"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("Error", "País con ID " + id + " no encontrado"));
        }
    }
}
