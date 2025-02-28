package com.microapps.countriesusb.entities;

import lombok.*;

public class CountriesEntity {

    public CountriesEntity(int id, String countryName, String countryCapital, String countryContinent, String countryCode) {
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryContinent = countryContinent;
        this.countryCode = countryCode;
    }

    public CountriesEntity(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    private int id;
    private String countryName;
    private String countryCapital;
    private String countryContinent;
    private String countryCode;


}
