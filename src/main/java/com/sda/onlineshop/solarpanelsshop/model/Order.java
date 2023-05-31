package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "order_number")
    private String orderNumber;

//    @NotNull(message = "Date of order must be not null!")
//    @PastOrPresent(message = "Date must be from present or past!")
    @Column(name = "date_of_order")
    private Date dateOfOrder;

    @NotNull(message = "Status must be not null")
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

//    @NotNull(message = "Amount must be not null!")
//    @NotBlank(message = "Amount must be not blank!")
    //@Pattern(regexp = "^\\d{0,8}[.]?\\d{1,4}$")
    @Column(name = "total_amount")
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "client_profile_id")
    private ClientProfile clientProfile;
    @OneToMany(mappedBy = "order")
    private List<ProductOrder> products;

    public Order() {
    }

    public Order(String orderNumber, Date dateOfOrder, OrderStatus status, double totalAmount) {
        this.orderNumber = orderNumber;
        this.dateOfOrder = dateOfOrder;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }


}
