package com.flipkart.implementations;

import java.util.ArrayList;
import java.util.Calendar;

public class CommissionBasedEmployee extends SalariedEmployee {
    private ArrayList<SalesReceipt> receipts;

    public CommissionBasedEmployee() {
        super();
        receipts = new ArrayList<>();
    }

    public void insertSalesReceipt(SalesReceipt salesReceipt){
        receipts.add(salesReceipt);
    }

    @Override
    public void toBePaid(Calendar uptoDate) {

    }


}
