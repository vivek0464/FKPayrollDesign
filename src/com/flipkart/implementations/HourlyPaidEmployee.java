package com.flipkart.implementations;

import java.util.ArrayList;
import java.util.Calendar;

public class HourlyPaidEmployee extends Employee{
    private ArrayList<TimeCard> timeCards;

    public HourlyPaidEmployee() {
        super();
        this.timeCards = new ArrayList<>();
    }

    public void insertTimeCard(TimeCard timeCard){
        timeCards.add(timeCard);
    }

    @Override
    public void toBePaid(Calendar uptoDate) {

    }
}
