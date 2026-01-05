package io.student.countrymap;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountrymapApplication implements CommandLineRunner {

    @Autowired(required = false)
    private Flyway flyway;

    public static void main(String[] args) {
        SpringApplication.run(CountrymapApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Flyway bean = " + flyway);
    }
}

