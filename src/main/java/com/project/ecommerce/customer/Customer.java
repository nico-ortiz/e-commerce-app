package com.project.ecommerce.customer;

import java.time.LocalDate;

import com.project.ecommerce.person.Person;

public class Customer extends Person{
    
    private String address;
    private String email;
    private String phone_number;
    private LocalDate day_of_birth;

    public Customer() {};

    public Customer(String name, String dni, String username, String address, String email, String phone_number, LocalDate date) {
        super(name, dni, username);
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.day_of_birth = date;
    };

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return  this.phone_number;
    }

    public LocalDate getBirthday() {
        return this.day_of_birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setBirthday(LocalDate day_of_birth) {
        this.day_of_birth = day_of_birth;   
    }

    public String toString() {
        return "Customer{" +
        "id=" + getId() + '\'' +
        "name=" + getName() + '\'' +
        "dni=" + getDni() + '\'' +
        "username=" + getUsername() + '\'' + 
        "address=" + this.address + '\'' +
        "email=" + this.email + '\'' +
        "phone_number=" + this.phone_number + '\'' +
        "birthday=" + this.day_of_birth + '\'' +
        "}";
    }
}
