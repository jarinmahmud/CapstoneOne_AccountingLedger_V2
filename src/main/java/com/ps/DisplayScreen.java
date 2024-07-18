package com.ps;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DisplayScreen {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LocalDate date = LocalDate.now();

    public DisplayScreen(){
    }

    public static void displayHomeScreen(){
        String selection;

        // Home Screen
        do {
            System.out.println("Welcome To The Accounting Ledger Home Screen Menu.");
            System.out.println("T) Add Transaction");
            System.out.println("L) Ledger Screen");
            System.out.println("X) Exit");
            System.out.print("Please make a selection: ");
            selection = scanner.nextLine().toUpperCase();

            switch (selection){
                case "T":
                    TransactionHandler.createTransaction();
                    break;
                case "L":
                    displayLedgerScreen();
                    break;
                case "X":
                    System.out.println("Thank you for using the Ledger Application!");
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (!selection.equals("X"));
    }

    public static void displayLedgerScreen(){
        String selection;
        // Ledger Screen
        do {
            System.out.println("Welcome to the Ledger Screen!");
            System.out.println("A) All");
            System.out.println("D) Deposits");
           // System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Please make a selection: ");
            selection = scanner.nextLine().toUpperCase();

            switch (selection) {
                case "A":
                    TransactionHandler.printTransactions();
                    break;
//                case "D":
//                    TransactionHandler.displayOnlyDeposits();
//                    break;
//                case "P":
//                    TransactionHandler.displayOnlyPayments();
//                    break;
//                case "R":
//                    displayReportsScreen();
//                    break;
                case "H":
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (!selection.equals("H"));
    }

    public static void displayReportsScreen(){
        List<Transaction> transactions;
        int selection = -1;
        // Reports Screen
        do {
            System.out.println("Welcome to the Reports Section!");
            System.out.println("1) Month To Date");
           // System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Search By Year");
            System.out.println("5) Custom Search");
            System.out.println("0) Back");
            System.out.print("Please make a selection: ");
            
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter numeric value.");
                scanner.nextLine();
                continue;
            }
            
            switch (selection) {
                case 1:
                    MyTransactionDao.searchByThisMonth();
                    break;
//                case 2:
//                    LocalDate prevMonthStart = date.minusMonths(1).withDayOfMonth(1);
//                    LocalDate prevMonthEnd = date.withDayOfMonth(1).minusDays(1);
//                    transactions = TransactionHandler.dateRangeTransactions(prevMonthStart, prevMonthEnd);
//                    TransactionHandler.printTransactions(transactions);
//                    break;
                case 3:
                    MyTransactionDao.searchByThisYear();
                    break;
                case 4:
                    MyTransactionDao.searchByThisYear();
                    break;
                case 5:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter start year: ");
                    int year = scanner.nextInt();

                    System.out.print("Enter start month: ");
                    int month = scanner.nextInt();

                    System.out.print("Enter start day: ");
                    int day = scanner.nextInt();

                    LocalDate localDate = LocalDate.of(year, month, day);

                    Date firstDate = Date.valueOf(localDate);

                    System.out.print("Enter end year: ");
                    int endYear = scanner.nextInt();

                    System.out.print("Enter end month: ");
                    int endMonth = scanner.nextInt();

                    System.out.print("Enter end day: ");
                    int endDay = scanner.nextInt();

                    LocalDate lastDate = LocalDate.of(year, month, endDay);

                    // Convert the LocalDate to java.sql.Date
                    Date lastDay = Date.valueOf(lastDate);

                   MyTransactionDao.searchByDateRange(firstDate, lastDay);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (selection!=0);
    }

//    public static void displayCustomSearch() {
//        List<Transaction> transactions;
//        int selection = -1;
//        // Custom Search
//        do {
//            System.out.println("Welcome to Custom Search!");
//            System.out.println("1) Any Value");
//            System.out.println("2) Date Range");
//            System.out.println("3) Description");
//            System.out.println("4) Vendor");
//            System.out.println("5) Amount");
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
//                    transactions = CustomSearch.randomValueSearch();
//                    TransactionHandler.printTransactions(transactions);
//                    break;
//                case 2:
//                    transactions = CustomSearch.searchByDateRange();
//                    if (transactions != null) {
//                        TransactionHandler.printTransactions(transactions);
//                    }
//                    else {
//                        System.out.println("Failed to load transactions.");
//                    }
//                    break;
//                case 3:
//                    transactions = CustomSearch.searchByDescription();
//                    TransactionHandler.printTransactions(transactions);
//                    break;
//                case 4:
//                    transactions = CustomSearch.searchByVendor();
//                    TransactionHandler.printTransactions(transactions);
//                    break;
//                case 5:
//                    transactions = CustomSearch.searchByAmount();
//                    if (transactions != null) {
//                        TransactionHandler.printTransactions(transactions);
//                    } else {
//                        System.out.println("Failed to load transactions.");
//                    }
//                    break;
//                case 0:
//                    break;
//                default:
//                    System.out.println("Invalid Selection Made. Please Try Again.");
//            }
//
//        } while (selection!=0);
//    }

}
