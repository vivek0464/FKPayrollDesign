package com.flipkart.implementations;

import java.util.HashMap;
import java.util.Map;

public class UnionMembership {
    private boolean isMember;
    private int duesRate;
    private Map<String, Integer> serviceCharges;

    public UnionMembership() {
        this.isMember = false;
        this.duesRate = 0;
        this.serviceCharges = new HashMap<>();
    }

    public boolean checkService(String service){
        if(serviceCharges.containsKey(service)){
            return true;
        }else{
            return false;
        }
    }

    public void insertService(String service){
        serviceCharges.put(service,0);
    }

    public void setServiceAndValue(String service, Integer value){
        serviceCharges.put(service,value);
    }

    public void setMembership(boolean member) {
        this.isMember = member;
    }

    public void setDuesRate(int duesRate) {
        this.duesRate = duesRate;
    }

    public boolean isMember() {
        return isMember;
    }

    public int getDuesRate() {
        return duesRate;
    }

    public Integer getServiceCharges(String service) {
        return serviceCharges.get(service);
    }
}
