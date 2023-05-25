package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Name must be not null!")
    @NotBlank(message = "Name must be not blank!")
    @Size(min = 2)
    @Column(name = "name")
    private String name;

    @NotNull(message = "Model must be not null!")
    @NotBlank(message = "Model must be not blank!")
    @Size(min = 2)
    @Column(name = "model")
    private String model;

    @NotNull(message = "Category must be not null!")
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ProductCategory category;

    @NotNull(message = "Description must be not null!")
    @NotBlank(message = "Description must be not blank!")
    @Size(min = 20)
    @Column(name = "description")
    private String description;

    @NotNull(message = "Price must be not null!")
    @Column(name = "price")
    private Double price;

    @Column(name = "promo_price")
    private Double promoPrice;

    @Column(name = "main_image_url")
    private String mainImageURL;

    public Product() {
    }

    public Product(String name, String model, ProductCategory category, String description, Double price, Double promoPrice, String mainImageURL) {
        this.name = name;
        this.model = model;
        this.category = category;
        this.description = description;
        this.price = price;
        this.promoPrice = promoPrice;
        this.mainImageURL = mainImageURL;
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

    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public String getMainImageURL() {
        return mainImageURL;
    }

    public void setMainImageURL(String mainImageURL) {
        this.mainImageURL = mainImageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
