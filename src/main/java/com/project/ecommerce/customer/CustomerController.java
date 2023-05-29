package com.project.ecommerce.customer;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService; 
    
    @GetMapping()
    public List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Customer createCustomer(@RequestBody Customer customer) throws Exception {
        try {
            Customer customer_save = customerService.createCustomer(customer);
            return customer_save;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }
      
}
