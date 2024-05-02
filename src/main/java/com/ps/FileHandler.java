package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileHandler {
    private static final String filename = "transactions.csv";

    public static void writeHeaderToFile(){
        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filename));
            buffWriter.write("date|time|description|vendor|amount");
            buffWriter.newLine();
            buffWriter.close();
        } catch (IOException e){
            System.out.println("ERROR initiating header to file!");
            e.printStackTrace();
        }
    }

    public static void writeToFile(Transaction transaction){
        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filename, true));

            // If new file, write header first
            File file = new File(filename);
            if (file.length() == 0) {
                writeHeaderToFile();
            }

            // Write transaction
            buffWriter.write(transaction.getDate() + "|" + transaction.getTime() + "|" +
                    transaction.getDescription() + "|" + transaction.getVendor() + "|" +
                    String.format("%.2f", transaction.getAmount()));
            buffWriter.newLine();
            buffWriter.close();
        } catch (IOException e){
            System.out.println("ERROR writing data to file!");
            e.printStackTrace();
        }
    }

    // Using List as it is preferred to convert to Linked later if ever necessary
    public static List<Transaction> readFromFile() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(filename));
            // Store each line from file into transaction
            String input;
            // Skip the first line, which is the header
            buffReader.readLine();
            while((input = buffReader.readLine()) != null){
                String[] data = input.split("\\|");
                LocalDate date = LocalDate.parse(data[0]);
                LocalTime time = LocalTime.parse(data[1]);
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);
                transactions.add(new Transaction(date, time, description, vendor, amount));
            }
        } catch (IOException e) {
            System.out.println("ERROR reading data from file!");
            e.printStackTrace();
        }
        // Sort by date, newest entry first
        transactions.sort(Comparator.comparing(Transaction::getDate).reversed());
        return transactions;
    }
}
