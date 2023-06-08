package com.project.ecommerce.admin;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.project.ecommerce.person.Person;

@Entity
@Table(name = "admins")
public class Admin extends Person {

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private LocalDate createdAt; 

    public Admin() {}

    public Admin(String name, String dni, String username, String email) {
        super(name, dni, username, email);
    }
}
