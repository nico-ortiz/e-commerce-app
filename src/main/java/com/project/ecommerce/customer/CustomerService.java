package com.project.ecommerce.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }
}
