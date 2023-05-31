package com.sda.onlineshop.solarpanelsshop.model.constant;

public enum ProductCategory {
    SOLAR_PANELS("Solar panels"),
    BATTERIES("Batteries"),
    SOLAR_INVERTERS("Solar inverters"),
    ACCESSORIES("Accessories");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
