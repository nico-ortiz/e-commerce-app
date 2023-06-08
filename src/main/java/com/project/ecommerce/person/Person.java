package com.project.ecommerce.person;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = false)
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: Name is NULL")
    private String name;

    @Column(name = "dni", length = 30, nullable = false, unique = true)
    @NotBlank(message = "Invalid dni: Empty dni")
    @NotNull(message = "Invalid dni: dni is NULL")
    private String dni;

    @Column(name = "username", length = 30, nullable = false, unique = false)
    @NotBlank(message = "Invalid username: Empty username")
    @NotNull(message = "Invalid username: username is NULL")
    private String username;    
    
    @Column(name = "email", length = 20, nullable = false)
    @Email(message = "Invalid email")
    private String email;

    public Person() {}

    public Person(String name, String dni, String username, String email) {
        this.name = name;
        this.dni  = dni;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDni() {
        return this.dni;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.id + '\'' + 
                "name=" + this.name + '\'' +
                "dni=" + this.dni + '\'' +
                "username=" + this.username + '\'' + 
                "email=" + this.email + '\'' + 
                "}";
    }
}
