package com.ps;

import java.sql.Time;
import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private Time time;
    private String description;
    private String transactionType;
    private String vendor;
    private double amount;

    public Transaction(double amount, Date date, String description, int id, Time time, String transactionType, String vendor) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.id = id;
        this.time = time;
        this.transactionType = transactionType;
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", time=" + time +
                ", transactionType='" + transactionType + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
