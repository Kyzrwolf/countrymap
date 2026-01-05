package io.student.countrymap.service;

import io.student.countrymap.domain.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryByName(String name);

    Country getCountryByICode(String iCode);

    Country addCountry(Country country);

    Country editCountryByICode(String iCode, Country updatedCountry);
}
