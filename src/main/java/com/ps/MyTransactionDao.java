package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MyTransactionDao extends MySqlDaoBase {

    public MyTransactionDao(DataSource dataSource) {
        super(dataSource);
    }

    // Existing methods...

    public static int createTransaction(Transaction transaction) {
        int id = -1;
        String sql = "INSERT INTO transactions (date, time, description, type_of_transaction, vendor, amount) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, transaction.getDate());
            preparedStatement.setTime(2, transaction.getTime());
            preparedStatement.setString(3, transaction.getDescription());
            preparedStatement.setString(4, transaction.getTransactionType());
            preparedStatement.setString(5, transaction.getVendor());
            preparedStatement.setDouble(6, transaction.getAmount());
            preparedStatement.executeUpdate();

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    id = keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Transaction searchByTransaction(int id) {
        Transaction transaction = null;
        String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    transaction = generateTransactionFromRS(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    // 5)
    public static List<Transaction> searchByDateRange(Date firstDate, Date secondDate) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE date BETWEEN ? AND ?";
        try (Connection connection = DatabaseHandler.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, firstDate);
            preparedStatement.setDate(2, secondDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Transaction transaction = generateTransactionFromRS(resultSet);
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
//
//
//    public static List<Transaction> searchByThisMonth() {
//        List<Transaction> transactions = new ArrayList<>();
//        String sql = "SELECT * FROM transactions WHERE date BETWEEN ? AND ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            LocalDate localDate = LocalDate.now();
//            Date date = Date.valueOf(localDate);
//            LocalDate firstDayOfMonth = localDate.withDayOfMonth(1);
//            Date firstDateOfMonth = Date.valueOf(firstDayOfMonth);
//
//            preparedStatement.setDate(1, firstDateOfMonth);
//            preparedStatement.setDate(2, date);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    Transaction transaction = generateTransactionFromRS(resultSet);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }
//
//    public static List<Transaction> searchByThisYear() {
//        List<Transaction> transactions = new ArrayList<>();
//        String sql = "SELECT * FROM transactions WHERE date BETWEEN ? AND ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            LocalDate localDate = LocalDate.now();
//            Date date = Date.valueOf(localDate);
//            LocalDate firstDayOfYear = localDate.withDayOfYear(1);
//            Date firstDateOfYear = Date.valueOf(firstDayOfYear);
//
//            preparedStatement.setDate(1, firstDateOfYear);
//            preparedStatement.setDate(2, date);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    Transaction transaction = generateTransactionFromRS(resultSet);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }
//
//    public List<Transaction> searchByYear(int year) {
//        List<Transaction> transactions = new ArrayList<>();
//        String sql = "SELECT * FROM transactions WHERE date BETWEEN ? AND ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
//            LocalDate lastDayOfYear = LocalDate.of(year, 12, 31);
//            Date firstDateOfYear = Date.valueOf(firstDayOfYear);
//            Date lastDateOfYear = Date.valueOf(lastDayOfYear);
//
//            preparedStatement.setDate(1, firstDateOfYear);
//            preparedStatement.setDate(2, lastDateOfYear);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    Transaction transaction = generateTransactionFromRS(resultSet);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }
//
//    public List<Transaction> searchByDescription(String description) {
//        List<Transaction> transactions = new ArrayList<>();
//        String sql = "SELECT * FROM transactions WHERE description = ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, description);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    Transaction transaction = generateTransactionFromRS(resultSet);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }
//
//    public List<Transaction> searchByVendor(String vendor) {
//        List<Transaction> transactions = new ArrayList<>();
//        String sql = "SELECT * FROM transactions WHERE vendor = ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, vendor);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    Transaction transaction = generateTransactionFromRS(resultSet);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }
//
//    public List<Transaction> searchByAmount(double amount) {
//        List<Transaction> transactions = new ArrayList<>();
//        String sql = "SELECT * FROM transactions WHERE amount = ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setDouble(1, amount);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    Transaction transaction = generateTransactionFromRS(resultSet);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }

    private static Transaction generateTransactionFromRS(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("transaction_id");
        LocalDate date = resultSet.getDate("date").toLocalDate();
        LocalTime time = resultSet.getTime("time") != null ? resultSet.getTime("time").toLocalTime() : null;
        String description = resultSet.getString("description");
        String transactionType = resultSet.getString("type_of_transaction");
        String vendor = resultSet.getString("vendor");
        BigDecimal amount = resultSet.getBigDecimal("amount");

        return new Transaction(id, date, time, description, transactionType, vendor, amount);
    }

    public static void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET date = ?, time = ?, description = ?, type_of_transaction = ?, vendor = ?, amount = ? WHERE transaction_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, transaction.getDate());
            preparedStatement.setTime(2, transaction.getTime());
            preparedStatement.setString(3, transaction.getDescription());
            preparedStatement.setString(4, transaction.getTransactionType());
            preparedStatement.setString(5, transaction.getVendor());
            preparedStatement.setBigDecimal(6, BigDecimal.valueOf(transaction.getAmount()));
            preparedStatement.setInt(7, transaction.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTransaction(int transactionId) {
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, transactionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}















