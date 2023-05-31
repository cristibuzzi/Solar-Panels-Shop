package com.sda.onlineshop.solarpanelsshop.model.constant;

public enum ConsultancyProductsType {
    NORMAL("Normal"),
    PREMIUM("Premium");

    private final String displayName;

    ConsultancyProductsType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
