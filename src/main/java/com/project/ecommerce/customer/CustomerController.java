package com.project.ecommerce.customer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/api/customer/{id}")
    public Customer getCustomer(@RequestParam Long id) {
        return customerService.getCustomer(id);
    }
    
    @PostMapping("/api/customer")
    public Customer postMethodName(@RequestBody Customer customer) {      
        return customerService.saveCustomer(customer);
    }
    
}
