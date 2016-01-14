package com.davidmiguel.taxsystem.entities;

public enum TaxCategory {
    CAT1("Free"),
    CAT2("10%"),
    CAT3("22%"),
    CAT4("40%");

    private final String description;

    TaxCategory(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
