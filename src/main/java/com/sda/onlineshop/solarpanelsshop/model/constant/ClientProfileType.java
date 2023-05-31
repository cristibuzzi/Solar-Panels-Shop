package com.sda.onlineshop.solarpanelsshop.model.constant;

public enum ClientProfileType {
    BASIC("Basic"),
    PREMIUM("Premium");

    private final String displayName;

    ClientProfileType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
