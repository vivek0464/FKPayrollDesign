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
}
