package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class MyTransactionDao extends MySqlDaoBase {
    private BasicDataSource dataSource;

    public MyTransactionDao(DataSource dataSource) {
        super(dataSource);
    }

    public int createTransaction(Transaction transaction) {
        int id = -1;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO transactions(transaction_id, date, time, description, type_of_transaction" +
                                "vendor, amount" + "VALUES (?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {
            preparedStatement.setInt(1, transaction.getId());
            preparedStatement.setDate(2, transaction.getDate());
            preparedStatement.setTime(3, transaction.getTime());
            preparedStatement.setString(4, transaction.getDescription());
            preparedStatement.setString(5, transaction.getTransactionType());
            preparedStatement.setString(6, transaction.getVendor());
            preparedStatement.setDouble(7, transaction.getAmount());
            preparedStatement.executeUpdate();

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    id = keys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public Transaction searchByTransaction(int id) {
        BasicDataSource dataSource;
        Transaction transaction = null;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM Transactions WHERE transaction_id = ? "

                );
        ){
            preparedStatement.setInt(1,id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    transaction = generateDealershipsFromRS(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaction;
        }


        public Transaction generateTransactionFromRS(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("transaction_id");
        Date date = resultSet.getDate("date");
        Time transaction = resultSet.getTime("time");
        String description = resultSet.getString("description");
        String transactionType = resultSet.getString("type_of_transaction");
        String vendor = resultSet.getString("vendor");
        Double amount = resultSet.getDouble("amount");



        return new Transaction(
                id,
                date,
                transaction,
                description,
                transactionType,
                vendor,
                amount
        );
    }

    }













