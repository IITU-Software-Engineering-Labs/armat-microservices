package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final List<Student> students = Arrays.asList(
            new Student(1, "Armat", "Computer Science", "Calisthenics"),
            new Student(2, "John", "Mechanical Engineering", "Football")
    );

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.of(students.stream().filter(s -> s.getId() == id).findFirst());
    }

    @GetMapping("/by-favorite-sport/{favoriteSport}")
    public List<Student> getStudentsByFavoriteSport(@PathVariable String favoriteSport) {
        return students.stream().filter(s -> s.getFavoriteSport().equalsIgnoreCase(favoriteSport)).collect(Collectors.toList());
    }
}