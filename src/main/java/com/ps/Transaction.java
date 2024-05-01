package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    // Constructor
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Getter and Setter
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void writeHeaderToFile(){
        try {
            String filename = "transactions.csv";
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filename));
            buffWriter.write("date|time|description|vendor|amount");
            buffWriter.newLine();
            buffWriter.close();
        } catch (IOException e){
            System.out.println("ERROR initiating header to file!");
            e.printStackTrace();
        }
    }

    public void writeToFile(){
        try {
            String filename = "transactions.csv";
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filename, true));

            // If new file, write header first
            File file = new File(filename);
            if (file.length() == 0) {
                writeHeaderToFile();
            }

            // Write transaction
            buffWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + String.format("%.2f", amount));
            buffWriter.newLine();
            buffWriter.close();
        } catch (IOException e){
            System.out.println("ERROR writing data to file!");
            e.printStackTrace();
        }
    }

    // Using List as it is preferred to convert to Linked later if ever necessary
    public List<Transaction> readFromFile() {
        String filename = "transactions.csv";
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(filename));

            // Store each line from file into transaction
            String input;

            // Skip the first line, which is the header
            buffReader.readLine();

            while((input = buffReader.readLine()) != null){
                String[] data = input.split("\\|");
                LocalDate date;
                LocalTime time;
                String description;
                String vendor;
                double amount;
            }
        } catch (IOException e){
            System.out.println("ERROR reading data from file!");
            e.printStackTrace();
        }
        // TODO: TRY SORTING HERE!
        return transactions;
    }

    // Instance Output
    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                '}';
    }
}
