package io.student.countrymap.service;

import io.student.countrymap.domain.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbCountryService implements CountryService {

    @Override
    public List<Country> getAllCountries() {
        return List.of(
                new Country("United States", "US", "USA"),
                new Country("Canada", "CA", "CAN")
        );
    }

    @Override
    public Country getCountryByName(String name) {
        return null;
    }

    @Override
    public Country getCountryByICode(String iCode) {
        return null;
    }

    @Override
    public Country addCountry(Country country) {
        return null;
    }

    @Override
    public Country editCountryByICode(String iCode, Country updatedCountry) {
        return null;
    }
}
