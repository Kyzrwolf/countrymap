package io.student.countrymap.domain;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.JsonNode;

public record Country(
        String name,
        String iCode,
        @JsonRawValue
        JsonNode coordinates
) {
}
