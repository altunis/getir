package com.getir.controller;

import com.getir.domain.Customer;
import com.getir.service.impl.CustomerServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;
    public CustomerController(CustomerServiceImpl service){
        this.customerService = service;
    }
    @PostMapping(value = "/save" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer save(@RequestBody Customer request) {
        return customerService.save(request);
    }
}
