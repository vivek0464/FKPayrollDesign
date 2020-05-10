package com.flipkart.implementations;
import java.util.*;

public abstract class Employee {
    private static Integer generateId = 1;
    private Integer id;
    private String name;
    private String address;
    private Calendar lastPaid;
    private Integer methodOfPayment;
    private UnionMembership membership;

    public Employee(){
        this.id = generateId++;
        this.name = null;
        this.address = null;
        this.lastPaid = Calendar.getInstance();
        this.methodOfPayment = 0;
        this.membership = new UnionMembership();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Calendar getLastPaid() {
        return lastPaid;
    }

    public Integer getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLastPaid(Calendar lastPaid) {
        this.lastPaid = lastPaid;
    }

    public void setMethodOfPayment(Integer methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public abstract void toBePaid(Calendar uptoDate);

}
