package com.ps;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySqlDaoBase {
    private static DataSource dataSource;

    public MySqlDaoBase(DataSource dataSource) {
        MySqlDaoBase.dataSource = dataSource;
    }

    protected static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}