package com.ps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomSearch {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transaction> transactions = FileHandler.readFromFile();

    // Deeper Search Customization - BONUS
    public static List<Transaction> randomValueSearch(){
        System.out.println("Please enter search phrase: ");
        String input = scanner.nextLine().toLowerCase();
        List<Transaction> searchResults = new ArrayList<>();

        for (Transaction transaction : transactions){
            // Use contains here because we want to return any result that contains any portion of the input user gives
            // This is because we already have methods for searching through specificities
            if(String.valueOf(transaction.getDate()).contains(input) ||
                    String.valueOf(transaction.getTime()).contains(input) ||
                    transaction.getDescription().toLowerCase().contains(input) ||
                    transaction.getVendor().toLowerCase().contains(input) ||
                    // Convert amount of type double to String value
                    String.valueOf(transaction.getAmount()).contains(input)){
                searchResults.add(transaction);
            }
        }
        return searchResults;
    }

    public static List<Transaction> searchByDateRange(){
        try {
            System.out.println("Please enter start date: ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.println("Please enter end date: ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());
            if (startDate.isAfter(endDate)) {
                System.out.println("ERROR: Start date cannot be after end date.");
                return null;
            }
            return TransactionHandler.dateRangeTransactions(startDate, endDate);
        } catch (Exception e) {
            System.out.println("Invalid Date Format.");
            return null;
        }
    }

    public static List<Transaction> searchByDescription(){
        System.out.println("Please enter description term: ");
        String input = scanner.nextLine().toLowerCase();
        List<Transaction> descriptionSearchResults = new ArrayList<>();

        for (Transaction transaction : transactions){
            // Use contains here for ability to search for sub phrase
            if(transaction.getDescription().toLowerCase().contains(input)){
                descriptionSearchResults.add(transaction);
            }
        }
        return descriptionSearchResults;
    }

    public static List<Transaction> searchByVendor(){
        System.out.println("Please enter name of vendor: ");
        String input = scanner.nextLine();
        List<Transaction> vendorSearchResults = new ArrayList<>();

        for (Transaction transaction : transactions){
            // Use equals here (and not contains) to get exact vendor match
            if(transaction.getVendor().equalsIgnoreCase(input)){
                vendorSearchResults.add(transaction);
            }
        }
        return vendorSearchResults;
    }

    public static List<Transaction> searchByAmount(){
        try {
            System.out.println("Please enter starting value of amount: ");
            double inputStart = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Please enter ending value of amount: ");
            double inputEnd = scanner.nextDouble();
            scanner.nextLine();
            List<Transaction> amountSearchResults = new ArrayList<>();

            if (inputStart > inputEnd) {
                System.out.println("ERROR: Starting amount cannot be greater than ending amount.");
                return null; // Handle invalid amount range
            }

            for (Transaction transaction : transactions) {
                // Get range amount matching
                if ((transaction.getAmount() >= inputStart) && (transaction.getAmount() <= inputEnd)) {
                    amountSearchResults.add(transaction);
                }
            }
            return amountSearchResults;
        } catch (Exception e) {
            System.out.println("Invalid Input!");
            scanner.nextLine();
            return null;
        }
    }
}
