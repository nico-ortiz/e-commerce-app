package com.project.ecommerce.product;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.ecommerce.category.Category;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "product_name", length = 30, nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = true)
    private Float productPrice;

    @Column(name = "product_brand_id", nullable = false, unique = true)
    private Long productBrandId;

    @Column(name = "stock_count", nullable = false)
    private int stockCount;
    
    @Column(name = "stock", nullable = false)
    private boolean stock;

    @Column(name = "category_id", nullable = false, unique = true)
    private Category categoryId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "updated_by", unique = true)
	private Long adminId;
    
    public Product() {};

    public Product(String name, Float price, Long product_brand_id, int stock_count, boolean stock, Category category) { 
        this.productName = name;
        this.productPrice = price;
        this.productBrandId = product_brand_id;
        this.stockCount = stock_count;
        this.stock = stock;
        this.categoryId = category;
    }

    public String getName() {
        return this.productName;
    }

    public Float getPrice() {
        return this.productPrice;
    }

    public Long getProductBrand() {
        return this.productBrandId;
    }

    public int getStockCount() {
        return this.stockCount;
    }

    public boolean getStock() {
        return this.stock;
    }

    public Category getCategory() {
        return  this.categoryId;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public void setPrice(Float price) {
        this.productPrice = price;
    }

    public void setProductBrand(Long product_brand_id) {
        this.productBrandId = product_brand_id;
    }

    public void setCountStock(int stock_count) {
        this.stockCount = stock_count;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public void setCategory(Category category_id) {
        this.categoryId = category_id;
    }

    public String toString() {
        return "Product{" +
        "id=" + this.productId + '\'' +
        "name=" + this.productName + '\'' +
        "price=" + this.productPrice + '\'' +
        "product_brand=" +  this.productBrandId + '\'' + 
        "stock_count=" + this.stockCount + '\'' +
        "stock=" + this.stock + '\'' +
        "category=" + this.categoryId + '\'' +
        "}";
    }
}

