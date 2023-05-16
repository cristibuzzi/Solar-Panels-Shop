package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyProductsType;
import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyRoofType;
import jakarta.persistence.*;

@Entity
@Table(name = "consultancy")
public class ConsultancyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "average_monthly_consumption")
    private Double averageMonthlyConsumption;
    @Column(name = "roof_type")
    private ConsultancyRoofType roofType;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAverageMonthlyConsumption() {
        return averageMonthlyConsumption;
    }

    public void setAverageMonthlyConsumption(double averageMonthlyConsumption) {
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

    @Override
    public String toString() {
        return "Consultancy{" +
                "id=" + id +
                ", averageMonthlyConsumption=" + averageMonthlyConsumption +
                ", roofType=" + roofType +
                ", productsType=" + productsType +
                '}';
    }
}
