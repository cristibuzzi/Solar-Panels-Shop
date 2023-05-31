package com.sda.onlineshop.solarpanelsshop.model.constant;

public enum ConsultancyRoofType {
    METAL_TILE("Metal tile"),
    METAL_TILE_WITH_ROCK("Metal tile with rock"),
    CONCRETE_TILE("Concrete tile"),
    CERAMIC_TILE("Ceramic tile"),
    BITUMINOUS_SHINGLE("Bituminous shingle"),
    CORRUGATED_SHEET("Corrugated sheet"),
    CUT_BOARD("Cut board");

    private final String displayName;

    ConsultancyRoofType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}
