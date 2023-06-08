package com.project.ecommerce.customer;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.ecommerce.admin.Admin;
import com.project.ecommerce.person.Person;

@Entity()
@Table(name = "customers")
public class Customer extends Person {
    
    @Column(name = "address", length = 30, nullable = false)
    @NotBlank(message = "Invalid address: Empty address")
    @NotNull(message = "Invalid address: Address is NULL")
    private String customerAddress;

    @Column(name = "phone_number", length = 30, nullable = false)
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String customerPhoneNumber;

    @Column(name = "birthday", length = 30, nullable = false)
    private LocalDate customerBirthday;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

    @ManyToOne
	@JoinColumn(name = "updated_by_admin_id")
	private Admin adminId; 

    public Customer() {};

    public Customer(String name, String dni, String username, String email, String address,  String phone_number, LocalDate date) {
        super(name, dni, username, email);
        this.customerAddress = address;
        this.customerPhoneNumber = phone_number;
        this.customerBirthday = date;
    };

    public String getAddress() {
        return this.customerAddress;
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
            "email=" + getEmail() + '\'' +
            "address=" + this.customerAddress + '\'' +
            "phone_number=" + this.customerPhoneNumber + '\'' +
            "birthday=" + this.customerBirthday + '\'' +
            "}";
    }
}
