package com.example.springevodemo.service;

import com.example.springevodemo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer customer1 = new Customer(1, "Elnur", 30);
        Customer customer2 = new Customer(2, "Ali", 25);
        Customer customer3 = new Customer(3, "Mahammad", 22);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void editCustomer(Integer customerId, Customer customer) {
        var customer1 = customers.stream()
                .filter(it -> it.getId().equals(customerId)).findFirst()
                .orElse(null);
        if (customer1 != null) {
            customer1.setFirstName(customer.getFirstName());
            customer1.setAge(customer.getAge());
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customers.removeIf(customer -> customer.getId().equals(customerId));
    }
}
