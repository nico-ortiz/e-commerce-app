package com.project.ecommerce.category;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.ecommerce.admin.Admin;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column(name = "category_name", length = 30, nullable = false)
    private String categoryName;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "updated_by", unique = true)
	private Admin idAdmin;

    public Category() {}

    public Category(String name) {
        this.categoryName = name;
    }

    public Long getId() {
        return this.categoryId;
    }

    public String getName() {
        return this.categoryName;
    }

    public void setName(String name) { 
        this.categoryName = name;
    }

    public String toString() {
        return "Category{" +
        "id=" + this.categoryId + '\'' +
        "name=" + this.categoryName + '\'' +
        "}";
    }

}
