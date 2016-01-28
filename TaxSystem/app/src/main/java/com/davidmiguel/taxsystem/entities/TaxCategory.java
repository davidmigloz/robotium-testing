package com.davidmiguel.taxsystem.entities;

public enum TaxCategory {
    CAT1(0),
    CAT2(10),
    CAT3(22),
    CAT4(40);

    private final int tax;

    TaxCategory(int tax) {
        this.tax = tax;
    }

    public int getTax() {
        return this.tax;
    }

    @Override
    public String toString() {
        if (this.tax == 0) {
            return "Free";
        }
        return this.tax + "%";
    }
}
