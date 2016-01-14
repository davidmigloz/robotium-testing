package com.davidmiguel.taxsystem.entities;

import com.orm.SugarRecord;

public class Employee extends SugarRecord {
    private String name;
    private String job;
    private int salary;
    private TaxCategory category;
    private int tax;

    public Employee(){
        // Default constructor is needed by SugarRecord
    }

    public Employee(String name, String job, int salary, TaxCategory category, int tax) {
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.category = category;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public TaxCategory getCategory() {
        return category;
    }

    public int getTax() {
        return tax;
    }
}
