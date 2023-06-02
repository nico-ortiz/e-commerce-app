package com.project.ecommerce.admin;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.project.ecommerce.person.Person;

@Entity
public class Admin extends Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

    @Column(name = "admin_username", length = 30, nullable = false, unique = true)
    private String adminUsername;
    
    @Column(name = "email_admin", length = 30, nullable = false, unique = true)
    private String adminEmail;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private LocalDate createdAt; 

    public Admin() {}

    public Admin(String adminUsername, String adminEmail) {
        this.adminUsername = adminUsername;
        this.adminEmail = adminEmail;
    }

    public String getUsername() {
        return this.adminUsername;
    }

    public String getEmail() {
        return this.adminEmail;
    }

    public void setUsername(String adminUserName) {
        this.adminUsername = adminUserName;
    }

    public void setEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String toString() {
        return "Admin{" +
        "id=" + getId() + '\'' +
        "username=" + getUsername() + '\'' + 
        "email=" + getEmail() + '\'' + 
        "}";
    }
}
