package org.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a Student entity with validation constraints.
 */
public class Student {
    private static int counter = 1; // Static counter for auto-generating student IDs
    private Integer id; // Unique student ID

    @NotNull
    @Size(min = 2, max = 40) // Name must be between 2 and 40 characters
    private String name;

    @NotNull
    @Email // Ensures a valid email format
    private String email;

    @NotNull
    @Min(18) // Minimum age requirement is 18
    private Integer age;

    /**
     * Constructor to initialize a Student object.
     * The ID is auto-incremented.
     *
     * @param name  Student's name (must be 2-40 characters)
     * @param email Student's email (must be a valid format)
     * @param age   Student's age (must be 18 or older)
     */
    public Student(String name, String email, Integer age) {
        this.id = counter++; // Assigns an auto-incremented ID
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters

    /**
     * Gets the student ID.
     * @return Student ID
     */
    public Integer getId() { return id; }

    /**
     * Sets the student ID.
     * @param id New ID for the student
     */
    public void setId(Integer id) { this.id = id; }

    /**
     * Gets the student's name.
     * @return Student's name
     */
    public String getName() { return name; }

    /**
     * Sets the student's name.
     * @param name New name for the student
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the student's email.
     * @return Student's email
     */
    public String getEmail() { return email; }

    /**
     * Sets the student's email.
     * @param email New email for the student
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets the student's age.
     * @return Student's age
     */
    public Integer getAge() { return age; }

    /**
     * Sets the student's age.
     * @param age New age for the student
     */
    public void setAge(Integer age) { this.age = age; }
}
