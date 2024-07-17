package com.ps;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Log start time
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Application started at:" + startTime);

        // Display welcome message
        System.out.println("Ledger application opened!");

        FileHandler.readFromFile();

        // Display home screen
        DisplayScreen.displayHomeScreen();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Application ended at: " + endTime);
    }
}