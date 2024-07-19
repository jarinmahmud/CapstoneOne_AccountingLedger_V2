package com.ps;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TransactionHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static Transaction createTransaction() {
        LocalDate date;
        Time time;
        String description;
        String vendor;
        BigDecimal amount;
        String transactionType;

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Enter Date: YYYY-MM-DD");
            date = LocalDate.parse(scanner.nextLine().trim(), dateFormatter);
        } catch (Exception e) {
            System.out.println("Invalid date format. Using Current Date.");
            date = LocalDate.now();
        }

        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println("Enter Time: HH:mm:ss");
            time = Time.valueOf(LocalTime.parse(scanner.nextLine().trim(), timeFormatter));
        } catch (Exception e) {
            System.out.println("Invalid time format. Using Current Time.");
            time = new Time(System.currentTimeMillis());
        }

        System.out.println("Enter Description: ");
        description = scanner.nextLine().trim();

        System.out.println("Enter Vendor: ");
        vendor = scanner.nextLine().trim();

        System.out.println("Enter Type of Transaction: ");
        transactionType = scanner.nextLine().trim();

        try {
            System.out.println("Enter Amount: ");
            amount = scanner.nextBigDecimal();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid Amount.");
            scanner.nextLine();
            return null;
        }

        Transaction transaction = new Transaction(0, date, time.toLocalTime(), description, transactionType, vendor, amount);
        MyTransactionDao.createTransaction(transaction);

        return transaction;
    }

    public static void printTransactions() {
        MyTransactionDao transactionDao = new MyTransactionDao(DatabaseHandler.getDataSource());
        List<Transaction> transactions = MyTransactionDao.searchByDateRange(Date.valueOf("1900-01-01"), Date.valueOf(LocalDate.now()));

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tTransactions:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-10s %-25s %-12s %-20s %10s%n",
                "id", "Date", "Time", "Description", "transactionType", "Vendor", "Amount");
        System.out.println("-----------------------------------------------------------------------------");

        for (Transaction transaction : transactions) {
            System.out.printf("%-10d %-12s %-10s %-25s %-12s %-20s %10.2f%n",
                    transaction.getId(), transaction.getDate(), transaction.getTime(), transaction.getDescription(),
                    transaction.getTransactionType(), transaction.getVendor(), transaction.getAmount());
        }
    }

    // Update transaction
    public static void updateTransaction(Transaction transaction) {
        MyTransactionDao.updateTransaction(transaction);
    }

    // Delete transaction
    public static void deleteTransaction(int transactionId) {
        MyTransactionDao.deleteTransaction(transactionId);
    }


}
