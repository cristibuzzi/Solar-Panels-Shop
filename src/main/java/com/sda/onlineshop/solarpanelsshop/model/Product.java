package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.ProductCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public Product() {
    }

    public Product(String name, String model, ProductCategory category, String description, Double price) {
        this.name = name;
        this.model = model;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
