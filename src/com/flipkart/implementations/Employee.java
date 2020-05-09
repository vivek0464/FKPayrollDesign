package com.flipkart.implementations;
import java.util.*;

interface Employee {
    int getId();
    int getName();
    int getAddress();
    int getLastPaid();

    void setName(String name);
    void setAddress(String address);
    void setLastPaid(Calendar lastPaid);
    void setDetails(String name, String address, Calendar lastPaid);


}
