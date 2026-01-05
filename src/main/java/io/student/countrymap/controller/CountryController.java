package io.student.countrymap.controller;

import io.student.countrymap.domain.Country;
import io.student.countrymap.domain.CountryAddRequest;
import io.student.countrymap.domain.CountryUpdateRequest;
import io.student.countrymap.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping("/add")
    public Country addCountry(@RequestBody CountryAddRequest request) {
        return countryService.addCountry(request);
    }

    @PutMapping("/edit/{iCode}")
    @Operation(summary = "Редактировать страну по ISO-коду")
    public Country editCountryByICode(@PathVariable String iCode, @RequestBody CountryUpdateRequest request) {
        return countryService.editCountryByICode(iCode, request);
    }
}
