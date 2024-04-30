package com.ps;

import java.util.Scanner;

public class DisplayScreen {
    private static final Scanner scanner = new Scanner(System.in);

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
            selection = scanner.next();

            switch (selection){
                case "D":
                    //addDeposit();
                    break;
                case "P":
                    //makePayment();
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
            selection = scanner.next();

            switch (selection) {
                case "A":
                    break;
                case "D":
                    break;
                case "P":
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
        int selection;
        // Reports Screen
        do {
            System.out.println("Welcome to the Reports Section!");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");
            System.out.print("Please make a selection: ");
            selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Selection Made. Please Try Again.");
            }
        } while (selection!=0);
    }

}
