package uts.isd.model.dao;

import uts.isd.model.User;

import java.sql.*;

public abstract class DBManager<T> {
    protected final Statement statement;
    protected final Connection connection;

    public DBManager(Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }

    public abstract T add(T object) throws SQLException;
    public abstract T get(T object) throws SQLException;
    public abstract void update(T oldObject, T newObject) throws SQLException;
    public abstract void delete(T object) throws SQLException;


}
