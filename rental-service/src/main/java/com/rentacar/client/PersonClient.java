package com.rentacar.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="person-service")
public interface PersonClient {
    @GetMapping("/api/persons/get/{id}")
    PersonDTO getPersonById(@PathVariable Long id);
}
