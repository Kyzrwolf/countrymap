package io.student.countrymap.data;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "icode", nullable = false, length = 3)
    private String iCode;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false)
    private JsonNode coordinates;

}
