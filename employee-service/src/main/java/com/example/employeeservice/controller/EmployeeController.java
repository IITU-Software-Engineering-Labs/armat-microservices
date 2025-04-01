package com.example.employeeservice.controller;


import com.example.employeeservice.feignClient.AddressClient;
import com.example.employeeservice.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final AddressClient addressClient;
    private static final List<Employee> employees = Arrays.asList(
            new Employee(1, "Armat", "Blue"),
            new Employee(2, "John", "Green")
    );

    public EmployeeController(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.of(employees.stream().filter(e -> e.getId() == id).findFirst());
    }

    @GetMapping("/by-favorite-color/{favoriteColor}")
    public List<Employee> getEmployeeByFavoriteColor(@PathVariable String favoriteColor) {
        return employees.stream().filter(e -> e.getFavoriteColor().equalsIgnoreCase(favoriteColor)).collect(Collectors.toList());
    }

    @GetMapping("/{id}/address")
    public String getEmployeeAddress(@PathVariable int id) {
        return addressClient.getAddress(id);
    }
}
