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
    private String address;

    @Column(name = "customer_email", length = 30, nullable = false)
    private String email;

    @Column(name = "customer_phone_number", length = 30, nullable = false)
    private String phoneNumber;

    @Column(name = "customer_birthday", length = 30, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "updated_by")
	private String updatedBy; //Cambiar a Admin

    public Customer() {};

    public Customer(String name, String dni, String username, String address, String email, String phone_number, LocalDate date) {
        super(name, dni, username);
        this.address = address;
        this.email = email;
        this.phoneNumber = phone_number;
        this.birthday = date;
    };

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return  this.phoneNumber;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;   
    }

    public String toString() {
        return "Customer{" +
        "id=" + getId() + '\'' +
        "name=" + getName() + '\'' +
        "dni=" + getDni() + '\'' +
        "username=" + getUsername() + '\'' + 
        "address=" + this.address + '\'' +
        "email=" + this.email + '\'' +
        "phone_number=" + this.phoneNumber + '\'' +
        "birthday=" + this.birthday + '\'' +
        "}";
    }
}
