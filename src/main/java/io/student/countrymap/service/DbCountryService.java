package io.student.countrymap.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.student.countrymap.data.CountryEntity;
import io.student.countrymap.data.CountryRepository;
import io.student.countrymap.domain.Country;
import io.student.countrymap.domain.CountryAddRequest;
import io.student.countrymap.domain.CountryUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbCountryService implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public DbCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(country -> {
                    return new Country(
                            country.getCountry(),
                            country.getICode(),
                            country.getCoordinates());
                })
                .toList();
    }

    @Override
    public Country addCountry(CountryAddRequest request) {
        var countryEntity = new CountryEntity();
        countryEntity.setCountry(request.name());
        countryEntity.setICode(request.iCode());

        JsonNode coordsNode = mapCoordinates(request.coordinates());
        countryEntity.setCoordinates(coordsNode);
        countryRepository.save(countryEntity);

        return new Country(request.name(), request.iCode(), coordsNode);
    }

    @Override
    public Country editCountryByICode(String iCode, CountryUpdateRequest request) {
        var countryByIcode = countryRepository.findAll()
                .stream()
                .filter(c -> c.getICode().equals(iCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country with iCode %s not found".formatted(iCode)));

        countryByIcode.setCountry(request.name());

        JsonNode coordsNode = mapCoordinates(request.coordinates());
        countryByIcode.setCoordinates(coordsNode);
        countryRepository.save(countryByIcode);

        return new Country(request.name(), iCode, coordsNode);
    }

    private JsonNode mapCoordinates(String coordinates) {
        var objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(coordinates);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Invalid JSON for coordinates", e);
        }
    }
}
