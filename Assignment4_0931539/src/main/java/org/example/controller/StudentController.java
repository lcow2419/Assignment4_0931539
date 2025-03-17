package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * Controller for managing student-related operations.
 */
@Controller
@RequestMapping("/students") // Base path for all student-related endpoints
public class StudentController {
    private final StudentService studentService;

    /**
     * Constructor to inject StudentService.
     * @param studentService Service layer for handling student data
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Displays the list of all students.
     * @param model Model to pass student data to the view
     * @return View name "students"
     */
    @GetMapping
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // Returns the view displaying all students
    }

    /**
     * Displays the form to add a new student.
     * @param model Model to pass an empty student object to the form
     * @return View name "new-student"
     */
    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student("", "", 18));
        return "new-student"; // Returns the view for adding a new student
    }

    /**
     * Handles form submission for adding a new student.
     * @param student Student object with form data
     * @param result BindingResult for validation errors
     * @return Redirects to the student list if successful, otherwise returns the form view
     */
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "new-student"; // Return form again if validation errors exist
        }
        studentService.addStudent(student);
        return "redirect:/students"; // Redirects to the student list after saving
    }

    /**
     * Deletes a student by ID.
     * @param id ID of the student to be deleted
     * @return Redirects to the student list after deletion
     */
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students"; // Redirects to the student list after deletion
    }

    /**
     * Exports all students in JSON format.
     * @return List of students as a JSON response
     */
    @GetMapping("/json")
    public ResponseEntity<List<Student>> exportStudentsAsJson() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
