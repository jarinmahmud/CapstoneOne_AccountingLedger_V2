package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TransactionHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transaction> transactions = FileHandler.readFromFile();
    private static BasicDataSource dataSource;

//    // Add Deposit - Positive Value
//    public static void addDeposit() {
//        System.out.println("Enter Deposit Details as follows:");
//        Transaction transaction = createTransaction();
//        if (transaction != null) {
//            FileHandler.writeToFile(transaction);
//            System.out.println("Your Deposit has been added successfully.");
//        } else {
//            System.out.println("Failed to add deposit.");
//        }
//    }
//
//    // Make Payment - Negative Value
//    public static void makePayment() {
//        System.out.println("Enter Payment Details as follows:");
//        Transaction transaction = createTransaction();
//        if (transaction != null) {
//            transaction.setAmount(-Math.abs(transaction.getAmount()));
//            FileHandler.writeToFile(transaction);
//            System.out.println("Your Payment has been added successfully.");
//        } else {
//            System.out.println("Failed to add deposit.");
//        }
//    }

    // Create Individual Transaction from Deposit / Payment
    public static Transaction createTransaction() {
        String description;
        String vendor;
        double amount;

        Date date = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Enter Date: YYYY-MM-DD");
            String input = scanner.nextLine().trim();
            LocalDate localDate = LocalDate.parse(input, formatter);

            Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
            // Convert Instant to java.sql.Date
            date = Date.from(instant);

        } catch (Exception e) {
            System.out.println("Invalid date format. Entering Current Date.");
            date = new Date();
        }

        Time time = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm[:ss]");
            System.out.println("Enter Time: HH-MM-SS");
            String input = scanner.nextLine().trim();
            LocalTime localTime = LocalTime.parse(input, formatter);

            time = Time.valueOf(localTime);

        } catch (Exception e) {
            System.out.println("Invalid time format. Entering Current Time.");
            time = new Time(System.currentTimeMillis());
        }

        System.out.println("Enter Description: ");
        description = scanner.nextLine().trim();

        System.out.println("Enter Vendor: ");
        vendor = scanner.nextLine().trim();

        System.out.println("Enter type of transaction");
        String transactionType = scanner.nextLine();

        try {
            System.out.println("Enter Amount: ");
            amount = scanner.nextDouble();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid Amount.");
            scanner.nextLine();
            return null;
        }

        int id = -1;
        Transaction transaction = new Transaction(amount, date, description, id, time, transactionType, vendor);

        return new Transaction(amount, date, description, transaction.getId(), time, transactionType, vendor);
    }

    // Print any list of transactions in a formatted way
    public static void printTransactions() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tTransactions:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-10s %-25s %-12s %-20s %10s%n",
                "id","Date", "Time", "Description", "transactionType", "Vendor", "Amount");
        System.out.println("-----------------------------------------------------------------------------");

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM transactions"
                );
        ) {


            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    for (Transaction transaction : transactions) {
                        System.out.printf("-10s %-12s %-10s %-25s %-12s %-20s %10s%n",
                                transaction.getId(),transaction.getDate(), transaction.getTime(),
                                transaction.getDescription(), transaction.getTransactionType(),
                                transaction.getVendor(),transaction.getAmount());
                    }
                    System.out.println("-----------------------------------------------------------------------------");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    // Print ALL transaction entries
//    public static void displayAllTransactions() {
//        List<Transaction> allTransactions = new ArrayList<>(transactions);
//        printTransactions(allTransactions);
//    }

//    // Show only Deposits
//    public static void displayOnlyDeposits() {
//        List<Transaction> onlyDeposits = new ArrayList<>();
//        for (Transaction transaction : transactions) {
//            if (transaction.getAmount() > 0) {
//                onlyDeposits.add(transaction);
//            }
//        }
//        printTransactions(onlyDeposits);
//    }

//    // Show only Payments
//    public static void displayOnlyPayments() {
//        List<Transaction> onlyPayments = new ArrayList<>();
//        for (Transaction transaction : transactions) {
//            if (transaction.getAmount() < 0) {
//                onlyPayments.add(transaction);
//            }
//        }
//        printTransactions(onlyPayments);
//    }

    // Return list of transactions with provided date range
//    public static List<Transaction> dateRangeTransactions(LocalDate startDate, LocalDate endDate){
//        List<Transaction> dateRange = new ArrayList<>();
//        for (Transaction transaction : transactions){
//             Doing the logic this way ensures start date and end date are included
//            if((!transaction.getDate().isBefore(startDate)) && (!transaction.getDate().isAfter(endDate))){
//                dateRange.add(transaction);
//            }
//        }
//        return dateRange;
//    }
}
