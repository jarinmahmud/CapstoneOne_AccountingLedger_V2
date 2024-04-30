package com.ps;

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
        System.out.println("Enter Time: HH-MM-SS");
        System.out.println("Enter Description: ");
        System.out.println("Enter Vendor: ");
        System.out.println("Enter Amount: ");
        return new Transaction(date, time, description, vendor, amount);
    }
}
