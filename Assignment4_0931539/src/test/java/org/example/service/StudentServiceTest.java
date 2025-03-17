package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StudentServiceTest {
    @Test
    public void testAddStudent() {
        StudentService service = new StudentService();
        service.addStudent(new Student("John Doe", "john@example.com", 22));
        assertEquals(1, service.getAllStudents().size());
    }

}
