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
        return findCustomerById(id);
    }

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest.getName(), customerRequest.getDni(), customerRequest.getUsername(), 
            customerRequest.getAddress(), customerRequest.getEmail(), 
            customerRequest.getPhoneNumber(), customerRequest.getBirthday());
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = findCustomerById(id);
        customerRepository.deleteById(id);
        return customer;
    }

    /**
     * Method to update a customer by id
     * @param id customer id
     * @param customerRequest new data customer to update the original customer 
     * @return the customer updated
     */
    public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = findCustomerById(id);
        customer.setName(customerRequest.getName());
        customer.setDni(customerRequest.getDni());
        customer.setUsername(customerRequest.getUsername());
        customer.setAddress(customerRequest.getAddress());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());  
        customer.setBirthday(customerRequest.getBirthday());
        return customerRepository.save(customer);
    } 

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).
            orElseThrow(() -> new CustomerNotFoundException("Customer with id = " + id + " not found"));    
    }
}