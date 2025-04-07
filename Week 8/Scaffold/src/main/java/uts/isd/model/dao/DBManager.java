package uts.isd.model.dao;

import uts.isd.model.User;

import java.sql.*;

public class DBManager {
    private final Statement statement;
    private final Connection connection;

    public DBManager(Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }
}
