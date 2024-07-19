package com.ps;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private int id;
    private Date date;
    private Time time;
    private String description;
    private String transactionType;
    private String vendor;
    private double amount;

    public Transaction(int id, LocalDate date, LocalTime time, String description, String transactionType, String vendor, BigDecimal amount) {
        this.id = id;
        this.date = Date.valueOf(date);
        this.time = (time != null) ? Time.valueOf(time) : null;
        this.description = description;
        this.transactionType = transactionType;
        this.vendor = vendor;
        this.amount = amount.doubleValue();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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