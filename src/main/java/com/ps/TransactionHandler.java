package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static void addDeposit(){
        System.out.println("Enter Deposit Details as follows:");
        Transaction transaction = createTransaction();
        FileHandler.writeToFile(transaction);
        System.out.println("Your Deposit has been added successfully.");
    }
    public static void makePayment(){
        System.out.println("Enter Payment Details as follows:");
        Transaction transaction = createTransaction();
        FileHandler.writeToFile(transaction);
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

    public static void displayAllTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        // load transactions
        transactions = FileHandler.readFromFile();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void displayOnlyDeposits(){
        List<Transaction> transactions = new ArrayList<>();
        // load transactions
        transactions = FileHandler.readFromFile();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0){
                System.out.println(transaction);
            }
        }
    }

    public static void displayOnlyPayments(){
        List<Transaction> transactions = new ArrayList<>();
        // load transactions
        transactions = FileHandler.readFromFile();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0){
                System.out.println(transaction);
            }
        }
    }

    public static List<Transaction> dateRangeTransactions(LocalDate startDate, LocalDate endDate){
        List<Transaction> transactions = new ArrayList<>();
        // load transactions
        transactions = FileHandler.readFromFile();
        for (Transaction transaction : transactions){
            // Doing the logic this way ensures start date and end date are included
            if((!transaction.getDate().isBefore(startDate)) && (!transaction.getDate().isAfter(endDate))){
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
