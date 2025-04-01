package com.example.addressservice.controller;

import com.example.addressservice.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private static final List<Address> addresses = Arrays.asList(
            new Address(1, "123", "Almaty", "Kazakhstan"),
            new Address(2, "456", "Astana", "Kazakhstan")
    );

    @GetMapping("/{employeeId}")
    public Address getAddress(@PathVariable int employeeId) {
        return addresses.stream()
                .filter(address -> address.getEmployeeId() == employeeId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }
}
