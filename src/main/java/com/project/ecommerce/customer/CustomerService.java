package com.project.ecommerce.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fge.jsonpatch.JsonPatch;
import com.project.ecommerce.exception.IdNotFoundException;

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

    public Customer createCustomer(Customer customer) {
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
     * @param customer new data customer to update the original customer 
     * @return the customer updated
     */
    public Customer updateCustomer(Long id, Customer customer) {
        Customer originalCustomer = findCustomerById(id);
        originalCustomer.setName(customer.getName());
        originalCustomer.setDni(customer.getDni());
        originalCustomer.setUsername(customer.getUsername());
        originalCustomer.setAddress(customer.getAddress());
        originalCustomer.setEmail(customer.getEmail());
        originalCustomer.setPhoneNumber(customer.getPhoneNumber());  
        originalCustomer.setBirthday(customer.getBirthday());
        return customerRepository.save(customer);
    } 

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).
            orElseThrow(() -> new IdNotFoundException("Customer with id = " + id + " not found"));    
    }
}