package com.project.ecommerce.customer;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.ecommerce.person.Person;

@Entity(name="customer")
public class Customer extends Person{
    
    @Column(name = "customer_address", length = 30, nullable = false)
    private String customerAddress;

    @Column(name = "customer_email", length = 30, nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone_number", length = 30, nullable = false)
    private String customerPhoneNumber;

    @Column(name = "customer_birthday", length = 30, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate customerBirthday;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "updated_by", unique = true)
	private Long adminId; 

    public Customer() {};

    public Customer(String name, String dni, String username, String address, String email, String phone_number, LocalDate date) {
        super(name, dni, username);
        this.customerAddress = address;
        this.customerEmail = email;
        this.customerPhoneNumber = phone_number;
        this.customerBirthday = date;
    };

    public String getAddress() {
        return this.customerAddress;
    }

    public String getEmail() {
        return this.customerEmail;
    }

    public String getPhoneNumber() {
        return  this.customerPhoneNumber;
    }

    public LocalDate getBirthday() {
        return this.customerBirthday;
    }

    public void setAddress(String address) {
        this.customerAddress = address;
    }

    public void setEmail(String email) {
        this.customerEmail = email;
    }

    public void setPhoneNumber(String phone_number) {
        this.customerPhoneNumber = phone_number;
    }

    public void setBirthday(LocalDate birthday) {
        this.customerBirthday = birthday;   
    }

    public String toString() {
        return "Customer{" +
        "id=" + getId() + '\'' +
        "name=" + getName() + '\'' +
        "dni=" + getDni() + '\'' +
        "username=" + getUsername() + '\'' + 
        "address=" + this.customerAddress + '\'' +
        "email=" + this.customerEmail + '\'' +
        "phone_number=" + this.customerPhoneNumber + '\'' +
        "birthday=" + this.customerBirthday + '\'' +
        "}";
    }
}
