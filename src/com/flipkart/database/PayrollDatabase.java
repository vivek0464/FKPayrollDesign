package com.flipkart.database;
import com.flipkart.implementations.Employee;

import java.util.*;

public class PayrollDatabase {
    private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    public Employee getEmployee(int employeeId) {
        return employees.get(employeeId);
    }

    public void addEmployee(int employeeId, Employee employee) {
        employees.put(employeeId, employee);
    }

    public void clear(){
        employees.clear();
    }

    public void deleteEmployee(int employeeId) {
        if(!employees.containsKey(employeeId)){
            System.out.println("Couldn't delete Employee Id: Employee doesn't exist");
        }else{
            employees.put(employeeId, null);
        }
    }

    public Set<Integer> getAllEmployeeIds() {
        return employees.keySet();
    }
}
