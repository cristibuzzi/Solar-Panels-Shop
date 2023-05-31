package com.sda.onlineshop.solarpanelsshop.model.constant;

public enum OrderStatus {
    REGISTERED("Registered"),
    IN_DELIVERY("In delivery"),
    DELIVERED("Delivered");

    private final String displayName;

    OrderStatus(String name) {
        this.displayName = name;
    }

    public String getName() {
        return displayName;
    }
}
