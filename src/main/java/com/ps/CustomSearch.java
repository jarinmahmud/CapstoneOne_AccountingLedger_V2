package com.ps;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomSearch {
    private static final LocalDate date = LocalDate.now();
    private static final Scanner scanner = new Scanner(System.in);

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
    public static void randomValueSearch(){
        System.out.println("Please enter search phrase: ");
        String input = scanner.nextLine();
    }

    public static void startDateSearch(){
        System.out.println("Please enter start date: ");
        String input = scanner.nextLine();
    }

    public static void endDateSearch(){
        System.out.println("Please enter end date: ");
        String input = scanner.nextLine();
    }

    public static void searchByDescription(){
        System.out.println("Please enter description term: ");
        String input = scanner.nextLine();
    }

    public static void searchByVendor(){
        System.out.println("Please enter name of vendor: ");
        String input = scanner.nextLine();
    }

    public static void searchByAmount(){
        System.out.println("Please enter amount search: ");
        int input = scanner.nextInt();
    }
}
