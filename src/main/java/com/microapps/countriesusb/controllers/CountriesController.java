package com.microapps.countriesusb.controllers;

import com.microapps.countriesusb.entities.CountriesEntity;
import com.microapps.countriesusb.services.CountriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountriesController {

    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping
        public List<CountriesEntity> getAllCountries() {
        return countriesService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountriesEntity getOneCountry(@PathVariable int id) {
        id = id -1;
        return countriesService.getCountriesById(id);
    }

    @PostMapping
    public String createCountry(@RequestBody CountriesEntity paisaCrearse) {
        CountriesEntity country = countriesService.addCountry(paisaCrearse);
        return country.toString();
    }

    @PutMapping("/{id}")
    public CountriesEntity updateCountry(@RequestBody CountriesEntity paisaActualizarse, @PathVariable int id) {
        CountriesEntity paisactualizado = countriesService.updateCountry(paisaActualizarse, id);
        return paisactualizado;
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable int id) {
        return countriesService.deleteCountryById(id);
    }

}
