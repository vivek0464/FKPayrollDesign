package com.flipkart.implementations;

import java.util.Calendar;

public class SalariedEmployee extends Employee{

    private Integer monthlySalary;

    public SalariedEmployee() {
        super();
        this.monthlySalary = monthlySalary;
    }

    public Integer getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Integer monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void toBePaid(Calendar uptoDate) {

    }
}
