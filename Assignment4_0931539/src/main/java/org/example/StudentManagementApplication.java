package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * Main class for the Student Management Application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class StudentManagementApplication {
    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    /**
     * Registers the Hidden HTTP Method Filter.
     * This filter allows HTTP methods like PUT and DELETE to be used in forms
     * by sending a hidden "_method" parameter.
     *
     * @return HiddenHttpMethodFilter instance
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}

