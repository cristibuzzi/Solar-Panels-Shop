package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyProductsType;
import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyRoofType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "consultancy")
public class ConsultancyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
//    @NotNull(message = "Average monthly consumption must be not null!")
//    @NotBlank(message = "Average monthly consumption must be not blank!")
   // @Pattern(regexp = "^\\d{0,8}[.]?\\d{1,4}$")
    @Column(name = "average_monthly_consumption")
    private Double averageMonthlyConsumption;
//    @NotNull(message = "Roof type must be not null")
    @Enumerated(EnumType.STRING)
    @Column(name = "roof_type")
    private ConsultancyRoofType roofType;
//    @NotNull(message = "Products type must be not null")
    @Enumerated(EnumType.STRING)
    @Column(name = "products_type")
    private ConsultancyProductsType productsType;

    @ManyToOne
    @JoinColumn(name = "client_profile_id")
    private ClientProfile client;


    public ConsultancyRequest() {
    }

    public ConsultancyRequest(double averageMonthlyConsumption, ConsultancyRoofType roofType, ConsultancyProductsType productsType) {
        this.averageMonthlyConsumption = averageMonthlyConsumption;
        this.roofType = roofType;
        this.productsType = productsType;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAverageMonthlyConsumption() {
        return averageMonthlyConsumption;
    }

    public void setAverageMonthlyConsumption(Double averageMonthlyConsumption) {
        this.averageMonthlyConsumption = averageMonthlyConsumption;
    }

    public ConsultancyRoofType getRoofType() {
        return roofType;
    }

    public void setRoofType(ConsultancyRoofType roofType) {
        this.roofType = roofType;
    }

    public ConsultancyProductsType getProductsType() {
        return productsType;
    }

    public void setProductsType(ConsultancyProductsType productsType) {
        this.productsType = productsType;
    }

    public ClientProfile getClient() {
        return client;
    }

    public void setClient(ClientProfile client) {
        this.client = client;
    }

}
