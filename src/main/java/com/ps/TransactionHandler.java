package com.ps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TransactionHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static void addDeposit(){
        System.out.println("Enter Deposit Details as follows:");
        Transaction transaction = createTransaction();
        transaction.writeToFile();
        System.out.println("Your Deposit has been added successfully.");
    }
    public static void makePayment(){
        System.out.println("Enter Payment Details as follows:");
        Transaction transaction = createTransaction();
        transaction.writeToFile();
        System.out.println("Your Payment has been added successfully.");
    }
    public static Transaction createTransaction(){
        System.out.println("Enter Date: YYYY-MM-DD");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Time: HH-MM-SS");
        LocalTime time = LocalTime.parse(scanner.nextLine());
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); //
        return new Transaction(date, time, description, vendor, amount);
    }

}
