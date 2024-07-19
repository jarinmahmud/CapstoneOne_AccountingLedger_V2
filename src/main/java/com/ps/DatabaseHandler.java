package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseHandler {

    private static final String PROPERTIES_FILE = "database.properties";

    public static DataSource getDataSource() {
        Properties properties = new Properties();
        try (InputStream inputStream = DatabaseHandler.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException("Unable to find " + PROPERTIES_FILE);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUsername(properties.getProperty("db.username"));
        dataSource.setPassword(properties.getProperty("db.password"));
        dataSource.setDriverClassName(properties.getProperty("db.driverClassName"));
        dataSource.setMinIdle(Integer.parseInt(properties.getProperty("db.minIdle")));
        dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("db.maxIdle")));
        dataSource.setMaxOpenPreparedStatements(Integer.parseInt(properties.getProperty("db.maxOpenPreparedStatements")));

        return dataSource;
    }
}