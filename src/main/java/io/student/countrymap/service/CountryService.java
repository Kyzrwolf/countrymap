package io.student.countrymap.service;

import io.student.countrymap.domain.Country;
import io.student.countrymap.domain.CountryAddRequest;
import io.student.countrymap.domain.CountryUpdateRequest;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country addCountry(CountryAddRequest request);

    Country editCountryByICode(String iCode, CountryUpdateRequest request);
}
