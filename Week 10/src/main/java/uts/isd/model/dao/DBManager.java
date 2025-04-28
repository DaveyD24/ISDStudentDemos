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

    protected abstract T add(T object) throws SQLException;
    protected abstract T get(T object) throws SQLException;
    protected abstract void update(T oldObject, T newObject) throws SQLException;
    protected abstract void delete(T object) throws SQLException;


}
