package com.flipkart.implementations;

import java.util.Calendar;
import java.util.Scanner;

public class AppRunner {
    void runPayRoll(){

    }

    public void printMenu(){
        System.out.println("Enter 1: Add a new employee");
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
        int input = 0;
        Scanner in = new Scanner(System.in);
        printMenu();
        do{
            try{
                input = Integer.parseInt(in.nextLine());
            }catch (NumberFormatException ex){
                System.out.println("Please provide valid option");
            }

        }while(input!=0);
    }
}
