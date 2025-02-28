package com.microapps.countriesusb.entities;

// Importación de la librería Lombok para generar automáticamente métodos como getters, setters y constructores
import lombok.*;

/**
 * Clase que representa la entidad "CountriesEntity" en la base de datos.
 * Contiene información sobre países, incluyendo su nombre, capital, continente y código.
 */
public class CountriesEntity {

    /**
     * Constructor parametrizado para inicializar una entidad con todos sus atributos.
     * @param id Identificador único del país.
     * @param countryName Nombre del país.
     * @param countryCapital Capital del país.
     * @param countryContinent Continente al que pertenece el país.
     * @param countryCode Código del país (ejemplo: "US" para Estados Unidos).
     */
    public CountriesEntity(Long id, String countryName, String countryCapital, String countryContinent, String countryCode) {
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryContinent = countryContinent;
        this.countryCode = countryCode;
    }

    /**
     * Constructor vacío necesario para ciertas operaciones de persistencia.
     */
    public CountriesEntity(){
    }

    /**
     * Métodos getter y setter para acceder y modificar los atributos de la entidad.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryContinent() {
        return countryContinent;
    }

    public void setCountryContinent(String countryContinent) {
        this.countryContinent = countryContinent;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Método toString para representar el objeto como una cadena de texto legible.
     * @return Representación en texto de la entidad con sus atributos.
     */
    @Override
    public String toString() {
        return "CountriesEntity{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", countryCapital='" + countryCapital + '\'' +
                ", countryContinent='" + countryContinent + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

    // Atributos privados de la entidad que representan las columnas de la base de datos
    private Long id; // Identificador único del país
    private String countryName; // Nombre del país
    private String countryCapital; // Capital del país
    private String countryContinent; // Continente al que pertenece el país
    private String countryCode; // Código del país (ejemplo: "US" para Estados Unidos)
}
