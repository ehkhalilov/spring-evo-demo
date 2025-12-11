package com.example.springevodemo.service;

import com.example.springevodemo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(Integer customerId);
    void addCustomer(Customer customer);
    void editCustomer(Integer customerId, Customer customer);
    void deleteCustomer(Integer customerId);
}
