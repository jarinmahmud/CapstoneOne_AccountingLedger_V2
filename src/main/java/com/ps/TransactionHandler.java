package com.ps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transaction> transactions = FileHandler.readFromFile();

    public static void addDeposit(){
        System.out.println("Enter Deposit Details as follows:");
        Transaction transaction = createTransaction();
        if (transaction != null) {
            FileHandler.writeToFile(transaction);
            System.out.println("Your Deposit has been added successfully.");
        } else {
            System.out.println("Failed to add deposit.");
        }
    }
    public static void makePayment(){
        System.out.println("Enter Payment Details as follows:");
        Transaction transaction = createTransaction();
        if (transaction != null) {
            transaction.setAmount(-Math.abs(transaction.getAmount()));
            FileHandler.writeToFile(transaction);
            System.out.println("Your Payment has been added successfully.");
        } else {
            System.out.println("Failed to add deposit.");
        }
    }
    public static Transaction createTransaction(){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String description;
        String vendor;
        double amount;

        try {
            System.out.println("Enter Date: YYYY-MM-DD");
            date = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Entering Current Date.");
        }

        try {
            System.out.println("Enter Time: HH-MM-SS");
            time = LocalTime.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid time format. Entering Current Time.");
        }

        System.out.println("Enter Description: ");
        description = scanner.nextLine();

        System.out.println("Enter Vendor: ");
        vendor = scanner.nextLine();

        try {
            System.out.println("Enter Amount: ");
            amount = scanner.nextDouble();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid Amount.");
            scanner.nextLine();
            return null;
        }
        return new Transaction(date, time, description, vendor, amount);
    }

    public static void printTransactions(List<Transaction> transactions){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tTransactions:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-----------------------------------------------------------------------------");

        for (Transaction transaction : transactions) {
            System.out.printf("%-12s %-10s %-25s %-20s $%.2f%n",
                    transaction.getDate(), transaction.getTime(),
                    transaction.getDescription(), transaction.getVendor(),
                    transaction.getAmount());
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void displayAllTransactions(){
        List<Transaction> allTransactions = new ArrayList<>(transactions);
        printTransactions(allTransactions);
    }

    public static void displayOnlyDeposits(){
        List<Transaction> onlyDeposits = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0){
                onlyDeposits.add(transaction);
            }
        }
        printTransactions(onlyDeposits);
    }

    public static void displayOnlyPayments(){
        List<Transaction> onlyPayments = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0){
                onlyPayments.add(transaction);
            }
        }
        printTransactions(onlyPayments);
    }

    public static List<Transaction> dateRangeTransactions(LocalDate startDate, LocalDate endDate){
        List<Transaction> dateRange = new ArrayList<>();
        for (Transaction transaction : transactions){
            // Doing the logic this way ensures start date and end date are included
            if((!transaction.getDate().isBefore(startDate)) && (!transaction.getDate().isAfter(endDate))){
                dateRange.add(transaction);
            }
        }
        return dateRange;
    }
}
