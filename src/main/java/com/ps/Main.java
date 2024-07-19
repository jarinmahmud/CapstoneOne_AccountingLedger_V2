package com.ps;

import javax.sql.DataSource;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Log start time
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Application started at:" + startTime);

        // Initialize DataSource
        DataSource dataSource = DatabaseHandler.getDataSource();

        // Pass DataSource to DAO
        MyTransactionDao transactionDao = new MyTransactionDao(dataSource);

        // Display welcome message
        System.out.println("Ledger application opened!");

        // Display home screen
        DisplayScreen.displayHomeScreen();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Application ended at: " + endTime);
    }
}