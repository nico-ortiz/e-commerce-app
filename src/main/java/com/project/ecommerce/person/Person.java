package com.project.ecommerce.person;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = false)
    private String name;

    @Column(name = "dni", length = 30, nullable = false, unique = true)
    private String dni;

    @Column(name = "username", length = 30, nullable = false, unique = false)
    private String username;    

    public Person() {}

    public Person(String name, String dni, String username) {
        this.name = name;
        this.dni  = dni;
        this.username = username;
    }

    public Person(Long id, String name, String dni, String username) {
        this.id = id;
        this.name = name;
        this.dni  = dni;
        this.username = username;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.id + '\'' +
                "name=" + this.name + '\'' +
                "dni=" + this.dni + '\'' +
                "username=" + this.username + '\'' + 
                "}";
    }
}
