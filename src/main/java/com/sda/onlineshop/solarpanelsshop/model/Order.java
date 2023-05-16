package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.OrderStatus;
import jakarta.persistence.*;

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
    @Column(name = "date_of_order")
    private Date dateOfOrder;
    @Column(name = "status")
    private OrderStatus status;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", dateOfOrder=" + dateOfOrder +
                ", status=" + status +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
