package com.project.ecommerce.product;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name", length = 30, nullable = false)
    private String name;

    @Column(name = "product_price", nullable = true)
    private Float price;

    @Column(name = "product_brand", length = 30, nullable = false)
    private String productBrand;

    @Column(name = "stock_count", nullable = false)
    private int stockCount;
    
    @Column(name = "stock", nullable = false)
    private boolean stock;

    @Column(name = "category_id", nullable = false, unique = true)
    private Long categoryId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "updated_by")
	private String updatedBy; //Cambiar a Admin
    
    public Product() {};

    public Product(String name, Float price, String product_brand, int stock_count, boolean stock, Long category) { 
        this.name = name;
        this.price = price;
        this.productBrand = product_brand;
        this.stockCount = stock_count;
        this.stock = stock;
        this.categoryId = category;
    }

    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return this.price;
    }

    public String getProductBrand() {
        return this.productBrand;
    }

    public int getStockCount() {
        return this.stockCount;
    }

    public boolean getStock() {
        return this.stock;
    }

    public Long getCategory() {
        return  this.categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setProductBrand(String product_brand) {
        this.productBrand = product_brand;
    }

    public void setCountStock(int stock_count) {
        this.stockCount = stock_count;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public void setCategory(Long category_id) {
        this.categoryId = category_id;
    }

    public String toString() {
        return "Product{" +
        "id=" + this.id + '\'' +
        "name=" + this.name + '\'' +
        "price=" + this.price + '\'' +
        "product_brand=" +  this.productBrand + '\'' + 
        "stock_count=" + this.stockCount + '\'' +
        "stock=" + this.stock + '\'' +
        "category=" + this.categoryId + '\'' +
        "}";
    }
}

