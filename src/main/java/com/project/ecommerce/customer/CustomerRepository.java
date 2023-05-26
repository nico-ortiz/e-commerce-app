package com.project.ecommerce.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    Customer findCustomer(Long id); 

    Customer saveCustomer(Customer entity);
}
