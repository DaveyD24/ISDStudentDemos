package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection connection;

    public DBConnector(String path) {
        System.setProperty("org.sqlite.lib.verbose", "true");
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:sqlite:RecordStoreDB.db";
        try {
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(true);
            System.out.println("Connected to database");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}