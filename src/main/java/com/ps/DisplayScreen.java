package com.ps;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DisplayScreen {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LocalDate date = LocalDate.now();

    public DisplayScreen() {
    }

    public static void displayHomeScreen() {
        String selection;

        // Home Screen
        do {
            System.out.println("Welcome To The Accounting Ledger Home Screen Menu.");
            System.out.println("T) Add Transaction");
            System.out.println("L) Ledger Screen");
            System.out.println("U) Update Transaction");
            System.out.println("D) Delete Transaction");
            System.out.println("X) Exit");
            System.out.print("Please make a selection: ");
            selection = scanner.nextLine().toUpperCase();

            switch (selection) {
                case "T":
                    TransactionHandler.createTransaction();
                    break;
                case "L":
                    displayLedgerScreen();
                    break;
                case "U":
                    updateTransactionScreen();
                    break;
                case "D":
                    deleteTransactionScreen();
                    break;
                case "X":
                    System.out.println("Thank you for using the Ledger Application!");
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (!selection.equals("X"));
    }

    public static void displayLedgerScreen() {
        String selection;
        // Ledger Screen
        do {
            System.out.println("Welcome to the Ledger Screen!");
            System.out.println("A) All");
          //  System.out.println("D) Deposits")
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Please make a selection: ");
            selection = scanner.nextLine().toUpperCase();

            switch (selection) {
                case "A":
                    TransactionHandler.printTransactions();
                    break;
             //   case "R":
             //       displayReportsScreen();
                case "H":
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (!selection.equals("H"));
    }

    public static void updateTransactionScreen() {
        System.out.print("Enter the transaction ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Transaction transaction = MyTransactionDao.searchByTransaction(id);
        if (transaction == null) {
            System.out.println("Transaction not found.");
            return;
        }

        System.out.println("Enter new Description (leave blank to keep current): ");
        String description = scanner.nextLine().trim();
        if (!description.isEmpty()) {
            transaction.setDescription(description);
        }

        System.out.println("Enter new Vendor (leave blank to keep current): ");
        String vendor = scanner.nextLine().trim();
        if (!vendor.isEmpty()) {
            transaction.setVendor(vendor);
        }

        System.out.println("Enter new Type of Transaction (leave blank to keep current): ");
        String transactionType = scanner.nextLine().trim();
        if (!transactionType.isEmpty()) {
            transaction.setTransactionType(transactionType);
        }

        try {
            System.out.println("Enter new Amount (leave blank to keep current): ");
            String amountInput = scanner.nextLine().trim();
            if (!amountInput.isEmpty()) {
                transaction.setAmount(Double.parseDouble(amountInput));
            }
        } catch (Exception e) {
            System.out.println("Invalid Amount.");
            return;
        }

        TransactionHandler.updateTransaction(transaction);
        System.out.println("Transaction updated successfully.");
    }

    public static void deleteTransactionScreen() {
        System.out.print("Enter the transaction ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        TransactionHandler.deleteTransaction(id);
        System.out.println("Transaction deleted successfully.");
    }

//    public static void displayReportsScreen(){
//        List<Transaction> transactions;
//        int selection = -1;
//        // Reports Screen
//        do {
//            System.out.println("Welcome to the Reports Section!");
//            System.out.println("1) Month To Date");
//            // System.out.println("2) Previous Month");
//            System.out.println("3) Year To Date");
//            System.out.println("4) Search By Year");
//            System.out.println("5) Custom Search");
//            System.out.println("0) Back");
//            System.out.print("Please make a selection: ");
//
//            try {
//                selection = scanner.nextInt();
//                scanner.nextLine();
//            } catch (Exception e) {
//                System.out.println("Invalid Input. Please enter numeric value.");
//                scanner.nextLine();
//                continue;
//            }
//
//            switch (selection) {
//                case 1:
//                    MyTransactionDao.searchByThisMonth();
//                    break;
////                case 2:
////                    LocalDate prevMonthStart = date.minusMonths(1).withDayOfMonth(1);
////                    LocalDate prevMonthEnd = date.withDayOfMonth(1).minusDays(1);
////                    transactions = TransactionHandler.dateRangeTransactions(prevMonthStart, prevMonthEnd);
////                    TransactionHandler.printTransactions(transactions);
////                    break;
//                case 3:
//                    MyTransactionDao.searchByThisYear();
//                    break;
//                case 4:
//                    MyTransactionDao.searchByThisYear();
//                    break;
//                case 5:
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.print("Enter start year: ");
//                    int year = scanner.nextInt();
//
//                    System.out.print("Enter start month: ");
//                    int month = scanner.nextInt();
//
//                    System.out.print("Enter start day: ");
//                    int day = scanner.nextInt();
//
//                    LocalDate localDate = LocalDate.of(year, month, day);
//
//                    Date firstDate = Date.valueOf(localDate);
//
//                    System.out.println();
//
//                    System.out.print("Enter end year: ");
//                    int endYear = scanner.nextInt();
//
//                    System.out.print("Enter end month: ");
//                    int endMonth = scanner.nextInt();
//
//                    System.out.print("Enter end day: ");
//                    int endDay = scanner.nextInt();
//
//                    LocalDate lastDate = LocalDate.of(year, month, endDay);
//
//
//                    // Convert the LocalDate to java.sql.Date
//                    Date lastDay = Date.valueOf(lastDate);
//
//                    System.out.println(lastDay);
//
//                    MyTransactionDao.searchByDateRange(firstDate, lastDay);
//                    break;
//                case 0:
//                    break;
//                default:
//                    System.out.println("Invalid Selection Made. Please Try Again.");
//            }
//        } while (selection!=0);
//    }


}
