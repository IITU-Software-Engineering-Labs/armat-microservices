package com.example.employeeservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service")
public interface AddressClient {
    @GetMapping("/address/{employeeId}")
    String getAddress(@PathVariable int employeeId);
}
