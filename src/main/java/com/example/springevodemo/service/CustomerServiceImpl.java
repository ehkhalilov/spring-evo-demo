package com.example.springevodemo.service;

import com.example.springevodemo.dao.CustomerEntity;
import com.example.springevodemo.dao.CustomerRepository;
import com.example.springevodemo.exception.NotFoundException;
import com.example.springevodemo.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        var customers = customerRepository.findAll();

        return customers.stream().map(it ->
                new Customer(it.getId(), it.getName(), 15))
                .toList();
    }

    @Override
    public Customer getCustomer(Integer customerId) {
//        customerRepository.findByNameAndBirthdate("Elnur", LocalDate.now());
        return null;
//        return customers.stream()
//                .filter(customer -> customer.getId().equals(customerId))
//                .findFirst()
//                .orElse(null);
    }

    @Override
    public void addCustomer(Customer customer) {
//        customers.add(customer);
    }

    @Override
    public void editCustomer(Integer customerId, Customer customer) {
//        var customer1 = customers.stream()
//                .filter(it -> it.getId().equals(customerId)).findFirst()
//                .orElse(null);
//        if (customer1 != null) {
//            customer1.setFirstName(customer.getFirstName());
//            customer1.setAge(customer.getAge());
//        }
    }
    // second comment
    @Override
    public void deleteCustomer(Integer customerId) {
//        customers.removeIf(customer -> customer.getId().equals(customerId));
    }
}
