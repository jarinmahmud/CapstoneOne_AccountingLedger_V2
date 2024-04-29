package com.ps;

import java.util.Scanner;

public class Main {
    // use scanner for input throughout code
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String selection;
        // Home Screen
        do {
            System.out.println("Welcome To The Accounting Ledger.");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger Screen");
            System.out.println("X) Exit");
            System.out.print("Please make a selection: ");
            selection = scanner.next();
        } while (!selection.equals("X"));
        System.out.println("Thank you for using the Ledger Application!");
    }
}