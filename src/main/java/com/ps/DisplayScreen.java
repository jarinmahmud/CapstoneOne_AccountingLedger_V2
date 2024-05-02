package com.ps;

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
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger Screen");
            System.out.println("X) Exit");
            System.out.print("Please make a selection: ");
            selection = scanner.nextLine().toUpperCase();

            switch (selection){
                case "D":
                    TransactionHandler.addDeposit();
                    break;
                case "P":
                    TransactionHandler.makePayment();
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
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Please make a selection: ");
            selection = scanner.nextLine().toUpperCase();

            switch (selection) {
                case "A":
                    TransactionHandler.displayAllTransactions();
                    break;
                case "D":
                    TransactionHandler.displayOnlyDeposits();
                    break;
                case "P":
                    TransactionHandler.displayOnlyPayments();
                    break;
                case "R":
                    displayReportsScreen();
                    break;
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
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Custom Search");
            System.out.println("0) Back");
            System.out.print("Please make a selection: ");
            
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter numeric value.");
                continue;
            }
            
            switch (selection) {
                case 1:
                    LocalDate month = date.withDayOfMonth(1);
                    transactions = TransactionHandler.dateRangeTransactions(month, date);
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 2:
                    LocalDate prevMonthStart = date.minusMonths(1).withDayOfMonth(1);
                    LocalDate prevMonthEnd = date.withDayOfMonth(1).minusDays(1);
                    transactions = TransactionHandler.dateRangeTransactions(prevMonthStart, prevMonthEnd);
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 3:
                    LocalDate year = date.withDayOfYear(1);
                    transactions = TransactionHandler.dateRangeTransactions(year, date);
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 4:
                    LocalDate prevYearStart = date.minusYears(1).withDayOfYear(1);
                    LocalDate prevYearEnd = date.withDayOfYear(1).minusDays(1);
                    transactions = TransactionHandler.dateRangeTransactions(prevYearStart, prevYearEnd);
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 5:
                    displayCustomSearch();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (selection!=0);
    }

    public static void displayCustomSearch() {
        List<Transaction> transactions;
        int selection = -1;
        // Reports Screen
        do {
            System.out.println("Welcome to Custom Search!");
            System.out.println("1) Any Value");
            System.out.println("2) Date Range");
            System.out.println("3) Description");
            System.out.println("4) Vendor");
            System.out.println("5) Amount");
            System.out.println("0) Back");
            System.out.print("Please make a selection: ");

            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter numeric value.");
                continue;
            }

            switch (selection) {
                case 1:
                    transactions = CustomSearch.randomValueSearch();
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 2:
                    transactions = CustomSearch.searchByDateRange();
                    if (transactions != null) {
                        TransactionHandler.printTransactions(transactions);
                    }
                    else {
                        System.out.println("Failed to load transactions.");
                    }
                    break;
                case 3:
                    transactions = CustomSearch.searchByDescription();
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 4:
                    transactions = CustomSearch.searchByVendor();
                    TransactionHandler.printTransactions(transactions);
                    break;
                case 5:
                    transactions = CustomSearch.searchByAmount();
                    if (transactions != null) {
                        TransactionHandler.printTransactions(transactions);
                    } else {
                        System.out.println("Failed to load transactions.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }

        } while (selection!=0);
    }

}
