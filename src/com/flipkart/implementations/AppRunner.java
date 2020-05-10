package com.flipkart.implementations;

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
            }else if(input == 2){
                Employee emp = new SalariedEmployee();
                databaseObject.addEmployee(emp.getId(),emp);
            }else if(input == 3){
                Employee emp = new CommissionBasedEmployee();
                databaseObject.addEmployee(emp.getId(),emp);
            }else{
                System.out.println("Couldn't add Employee: Not provided valid input");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't add Employee: Not provided valid input");
        }

    }

    private void deleteEmployee(PayrollDatabase databaseObject){
        System.out.println("Please provide Employee Id you want to delete");
        try{
            Scanner in = new Scanner(System.in);
            Integer empId = Integer.parseInt(in.nextLine());
            databaseObject.deleteEmployee(empId);
        }catch (NumberFormatException ex){
            System.out.println("Couldn't delete Employee: Not provided valid Employee Id");
        }
    }

    private void printEmployees(PayrollDatabase databaseObject){
        for(Integer empId: databaseObject.getAllEmployeeIds()){
            System.out.println(empId);
        }
    }

    private void printMenu(){
        System.out.println("\n\nEnter 1: Add a new employee");
        System.out.println("Enter 2: Delete an employee");
        System.out.println("Enter 3: Post a time card");
        System.out.println("Enter 4: Post a sales receipt");
        System.out.println("Enter 5: Post a union membership, service charge etc.");
        System.out.println("Enter 6: Change employee details (e.g., hourly rate, dues rate, membership fee etc)");
        System.out.println("Enter 7: Run the payroll for today");
        System.out.println("Enter 8: To view menu");
        System.out.println("Enter 0: To exit from the portal\n");

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
                }
            }catch (NumberFormatException ex){
                System.out.println("Please provide valid option");
            }

        }while(input!=0);

        printEmployees(databaseObject);

    }
}
