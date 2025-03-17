package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(StudentController.class)  // ✅ Use WebMvcTest for controller tests
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean  // ✅ Mock the service so Spring doesn't require the real bean
    private StudentService studentService;

    @Test
    void shouldReturnStudentsList() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(
                new Student("John Doe", "john@example.com", 20),
                new Student("Jane Doe", "jane@example.com", 22)
        ));

        mockMvc.perform(get("/students/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"));
    }
}
