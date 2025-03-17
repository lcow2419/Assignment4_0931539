package org.example.service;

import org.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing student data.
 */
@Service
public class StudentService {
    // List to store students (acting as in-memory storage)
    private final List<Student> students = new ArrayList<>();

    /**
     * Retrieves the list of all students.
     *
     * @return List of students
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Adds a new student to the list.
     *
     * @param student The student object to be added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Deletes a student from the list by their ID.
     *
     * @param id The ID of the student to be removed
     */
    public void deleteStudent(Integer id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
