package com.project.ecommerce.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest.getName(), customerRequest.getDni(), customerRequest.getEmail(), customerRequest.getAddress(), customerRequest.getEmail(), customerRequest.getPhoneNumber(), customerRequest.getBirthday());
        return customerRepository.save(customer);
    }
}
