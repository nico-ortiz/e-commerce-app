package com.project.ecommerce.customer;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CustomerRequest{

    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String name;
    
    @NotBlank(message = "Invalid dni: Empty dni")
    @NotNull(message = "Invalid dni: dni is NULL")
    private String dni;
    
    @NotBlank(message = "Invalid username: Empty username")
    @NotNull(message = "Invalid username: username is NULL")
    private String username;
    
    @NotBlank(message = "Invalid address: Empty address")
    @NotNull(message = "Invalid address: Address is NULL") 
    private String address;
    
    @Email(message = "Invalid email")
    private String email;
    
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phoneNumber;

    private LocalDate birthday;

}