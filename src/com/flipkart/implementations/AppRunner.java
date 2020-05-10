package com.flipkart.implementations;

import java.awt.geom.Arc2D;
import java.util.Calendar;
import java.util.Scanner;
import com.flipkart.database.PayrollDatabase;

public class AppRunner {
    private void addEmployee(PayrollDatabase databaseObject){
        System.out.println("What type of Employee you want to add ?");
        System.out.println("Enter 1: To add Hourly Paid Employee");
        System.out.println("Enter 2: To add Salaried Employee");
        System.out.println("Enter 3: To add Commission Paid Employee");
        Scanner in = new Scanner(System.in);
        int input = 0;
        try {
            input = Integer.parseInt(in.nextLine());
            if(input == 1){
                Employee emp = new HourlyPaidEmployee();
                databaseObject.addEmployee(emp.getId(),emp);
                System.out.println("Employee Added Succesfully\n");
            }else if(input == 2){
                Employee emp = new SalariedEmployee();
                databaseObject.addEmployee(emp.getId(),emp);
                System.out.println("Employee Added Succesfully\n");
            }else if(input == 3){
                Employee emp = new CommissionBasedEmployee();
                databaseObject.addEmployee(emp.getId(),emp);
                System.out.println("Employee Added Succesfully\n");
            }else{
                System.out.println("Couldn't add Employee: Not provided valid input\n");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't add Employee: Not provided valid input\n");
        }

    }

    private void deleteEmployee(PayrollDatabase databaseObject){
        System.out.println("Please provide Employee Id you want to delete");
        try{
            Scanner in = new Scanner(System.in);
            Integer empId = Integer.parseInt(in.nextLine());
            databaseObject.deleteEmployee(empId);
            System.out.println("Employee deleted successfully\n");
        }catch (NumberFormatException ex){
            System.out.println("Couldn't delete Employee: Not provided valid Employee Id\n");
        }
    }

    private void postTimeCard(PayrollDatabase databaseObject){
        System.out.println("Please provide Employee Id for which you want to post TimeCard");
        try{
            Scanner in = new Scanner(System.in);
            Integer empId = Integer.parseInt(in.nextLine());
            if(databaseObject.isEmloyeePresent(empId)){
                if(databaseObject.isHourlyPaidEmployee(empId)){
                    HourlyPaidEmployee emp = (HourlyPaidEmployee) databaseObject.getEmployee(empId);
                    try{
                        System.out.println("Please provide the amount(in Rupees) of the sale");
                        Double hours = Double.parseDouble(in.nextLine());
                        emp.insertTimeCard(new TimeCard(Calendar.getInstance(),hours));
                        System.out.println("Time Card Posted Succesfully\n");
                    }catch (NumberFormatException ex){
                        System.out.println("Couldn't post Time Cards: Not provided valid number of Hours\n");
                    }
                }else{
                    System.out.println("Couldn't post Time Card: Employee Id is not an Instance of HourlyPaidEmployee class\n");
                }
            }else{
                System.out.println("Couldn't post Time Card: Employee Id doesn't exist\n");
            }
        }catch (NumberFormatException ex){
            System.out.println("Couldn't post Time Card: Not provided valid Employee Id\n");
        }
    }

    private void postSalesReceipt(PayrollDatabase databaseObject){
        System.out.println("Please provide Employee Id for which you want to post SalesReceipt");
        try{
            Scanner in = new Scanner(System.in);
            Integer empId = Integer.parseInt(in.nextLine());
            if(databaseObject.isEmloyeePresent(empId)){
                if(databaseObject.isCommissionBasedEmployee(empId)){
                    CommissionBasedEmployee emp = (CommissionBasedEmployee) databaseObject.getEmployee(empId);
                    try{
                        System.out.println("Please provide the amount(in Rupees) of the sale");
                        Double amount = Double.parseDouble(in.nextLine());
                        emp.insertSalesReceipt(new SalesReceipt(Calendar.getInstance(),amount));
                        System.out.println("Sales Receipt Posted Succesfully\n");
                    }catch (NumberFormatException ex){
                        System.out.println("Couldn't post Sales Receipt: Not provided valid amount of sales\n");
                    }
                }else{
                    System.out.println("Couldn't post Sales Receipt: Employee Id is not an Instance of CommissionBasedEmployee class\n");
                }
            }else{
                System.out.println("Couldn't post Sales Receipt: Employee Id doesn't exist\n");
            }
        }catch (NumberFormatException ex){
            System.out.println("Couldn't post Sales Receipt: Not provided valid Employee Id\n");
        }
    }  

    private void printEmployees(PayrollDatabase databaseObject){
        for(Integer empId: databaseObject.getAllEmployeeIds()){
            System.out.println(empId);
        }
    }

    private void printMenu(){
        System.out.println("\nEnter 1: Add a new employee");
        System.out.println("Enter 2: Delete an employee");
        System.out.println("Enter 3: Post a time card");
        System.out.println("Enter 4: Post a sales receipt");
        System.out.println("Enter 5: Post a union membership, service charge etc.");
        System.out.println("Enter 6: Change employee details (e.g., hourly rate, dues rate, membership fee etc)");
        System.out.println("Enter 7: Run the payroll for today");
        System.out.println("Enter 8: To view menu");
        System.out.println("Enter 0: To exit from the portal");

    }

    public void run(){
        System.out.println("Hello User, Welcome to the Flipkart Payroll Portal\n");
        PayrollDatabase databaseObject = new PayrollDatabase();
        int input = 0;
        Scanner in = new Scanner(System.in);
        printMenu();
        do{
            try{
                input = Integer.parseInt(in.nextLine());
                if(input == 1){
                    addEmployee(databaseObject);
                    printMenu();
                }else if(input == 2){
                    deleteEmployee(databaseObject);
                    printMenu();
                }else if(input == 3){
                    postTimeCard(databaseObject);
                    printMenu();
                }else if(input == 4){
                    postSalesReceipt(databaseObject);
                    printMenu();
                }else if(input == 5){
                    System.out.println("Feature Not Yet Implemented");
                }else if(input == 6){
                    System.out.println("Feature Not Yet Implemented");
                }else if(input == 7){
                    System.out.println("Feature Not Yet Implemented");
                }
            }catch (NumberFormatException ex){
                System.out.println("Please provide valid option");
            }

        }while(input!=0);

        printEmployees(databaseObject);

    }
}
