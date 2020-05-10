package com.flipkart.database;
import com.flipkart.implementations.CommissionBasedEmployee;
import com.flipkart.implementations.Employee;
import com.flipkart.implementations.HourlyPaidEmployee;
import com.flipkart.implementations.SalariedEmployee;

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
            employees.remove(employeeId);
        }
    }

    public Set<Integer> getAllEmployeeIds() {
        return employees.keySet();
    }


    public boolean isEmloyeePresent(int employeeId){
        return employees.containsKey(employeeId);
    }

    public boolean isHourlyPaidEmployee(int employeeId){
        if(!isEmloyeePresent(employeeId)){
            return false;
        }
        return employees.get(employeeId) instanceof HourlyPaidEmployee;
    }

    public boolean isSalariedEmployee(int employeeId){
        if(!isEmloyeePresent(employeeId)){
            return false;
        }
        return employees.get(employeeId) instanceof SalariedEmployee;
    }

    public boolean isCommissionBasedEmployee(int employeeId){
        if(!isEmloyeePresent(employeeId)){
            return false;
        }
        return employees.get(employeeId) instanceof CommissionBasedEmployee;
    }
}
