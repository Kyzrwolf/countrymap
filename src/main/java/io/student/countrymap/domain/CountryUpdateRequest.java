package io.student.countrymap.domain;

public record CountryUpdateRequest(
        String name,
        String coordinates
) {}
