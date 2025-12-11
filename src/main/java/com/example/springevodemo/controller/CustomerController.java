package com.example.springevodemo.controller;

import com.example.springevodemo.model.Customer;
import com.example.springevodemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) {
        // this comment for github commit
        customerService.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public void editCustomer(@RequestBody Customer customer,
                             @PathVariable  int customerId) {
        customerService.editCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
