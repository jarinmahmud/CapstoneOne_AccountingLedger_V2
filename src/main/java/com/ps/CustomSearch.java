package com.ps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CustomSearch {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LocalDate date = LocalDate.now();
    private static final List<Transaction> transactions = Transaction.readFromFile();

    // Simple Search Customizations
    public static void monthToDate(){
        // Takes the current month and returns the date with the provided day of choice
        // In this case, use 1 to get the date for the first day of the current month
        LocalDate month = date.withDayOfMonth(1);
        System.out.println(month);
    }

    public static void previousMonth(){
        // Returns the date with provided amount of months subtracted from current date
        // Then returns the date of that month with the provided day of choice
        // In this case, use 1 to subtract into the previous month from current date
        // Then 1 again to get the start date of that returned month
        LocalDate prevMonth = date.minusMonths(1).withDayOfMonth(1);
        System.out.println(prevMonth);
    }

    public static void yearToDate(){
        // Similar logic as monthToDate method
        LocalDate year = date.withDayOfYear(1);
        System.out.println(year);
    }

    public static void previousYear(){
        // Similar logic as previousMonths method
        LocalDate year = date.minusYears(1).withDayOfYear(1);
        System.out.println(year);
    }

    // Deeper Search Customization - BONUS
    public static List<Transaction> randomValueSearch(){
        System.out.println("Please enter search phrase: ");
        String input = scanner.nextLine().toLowerCase();
        List<Transaction> searchResults = new ArrayList<>();

        for (Transaction transaction : transactions){
            // Use contains here because we want to return any result that contains the input we give
            // As we already have the search by value methods for specificities
            if(transaction.getDescription().contains(input) ||
                    transaction.getVendor().contains(input) ||
                    // Convert amount of type double to String value
                    String.valueOf(transaction.getAmount()).contains(input)){
                searchResults.add(transaction);
            }
        }
        return searchResults;
    }

    public static void startDateSearch(){
        System.out.println("Please enter start date: ");
        String input = scanner.nextLine();
    }

    public static void endDateSearch(){
        System.out.println("Please enter end date: ");
        String input = scanner.nextLine();
    }

    public static List<Transaction> searchByDescription(){
        System.out.println("Please enter description term: ");
        String input = scanner.nextLine();
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
        System.out.println("Please enter value of amount: ");
        int input = scanner.nextInt();
        List<Transaction> amountSearchResults = new ArrayList<>();

        for (Transaction transaction : transactions){
            // Get exact amount matching
            if(transaction.getAmount() == input){
                amountSearchResults.add(transaction);
            }
        }
        return amountSearchResults;
    }
}
