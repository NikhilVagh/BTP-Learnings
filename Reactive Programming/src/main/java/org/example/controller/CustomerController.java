package org.example.controller;

import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public List<Customer> getAll(){
        return service.loadAllCustomer();
    }

    @GetMapping(value="/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllStream(){
        return service.loadAllCustomerStream();
    }
}
