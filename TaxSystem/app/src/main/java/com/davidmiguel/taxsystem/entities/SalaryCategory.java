package com.davidmiguel.taxsystem.entities;

public enum SalaryCategory {
    CAT1(4000), // salary < 4000
    CAT2(5500), // 4000 <= salary < 5500
    CAT3(33500), // 5500 <= salary < 33500
    CAT4(Integer.MAX_VALUE); // salary >= 33500

    private final int maxSalary;

    SalaryCategory(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public double getMaxSalary() {
        return this.maxSalary;
    }
}
