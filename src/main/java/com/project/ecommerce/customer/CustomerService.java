package com.project.ecommerce.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.exception.CustomerNotFoundException;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id = " + id + " not found"));    
    }

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest.getName(), customerRequest.getDni(), customerRequest.getEmail(), customerRequest.getAddress(), customerRequest.getEmail(), customerRequest.getPhoneNumber(), customerRequest.getBirthday());
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).
            orElseThrow(() -> new CustomerNotFoundException("Customer with id = " + id + " not found"));
        customerRepository.deleteById(id);
        return customer;
    }
}
