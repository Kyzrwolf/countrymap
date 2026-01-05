package io.student.countrymap.domain;

public record CountryAddRequest(
        String name,
        String iCode,
        String coordinates
) {
}
