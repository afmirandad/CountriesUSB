package com.microapps.countriesusb.services;

import com.microapps.countriesusb.entities.CountriesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountriesService {

    private final List<CountriesEntity> countries = new ArrayList<>();
    private int currentId = 1;

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
    }

    public List<CountriesEntity> getAllCountries() {
        return countries;
    }

    public CountriesEntity getCountriesById(int id) {
        return countries.get(id);
    }

    public CountriesEntity getCountriesByContinent(String continent) {
        int index = countries.indexOf(continent);
        return countries.get(index);
    }

    public CountriesEntity addCountry(CountriesEntity country) {
        if (country.getId() != 0 ){
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).getId() == country.getId()) {
                    return countries.get(i);
                }else{
                    countries.add(country);
                }
            }
        }else{
            country.setId(currentId++);
            countries.add(country);
        }
        return country;
    }

    public CountriesEntity updateCountry(CountriesEntity country, int id) {
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getId() == id) {
                country.setId(id);
                countries.set(i, country);
                return country;
            }
        }
        return country;
    }

    public String deleteCountryById(int id) {
        countries.remove(id);
        return "Pais eliminado";
    }

}
