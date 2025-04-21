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

    public int getUserCount() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
        resultSet.next();
        return resultSet.getInt(1);
    }

    //CREATE
    public void addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (email, password, genre) VALUES (?, ?, ?)");
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getGenre());
        preparedStatement.executeUpdate();
    }

    //READ
    public User getUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        preparedStatement.setString(1, user.getEmail());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String genre = resultSet.getString("genre");
            return new User(email, password, genre);
        }
        return null;
    }

    //UPDATE
    public void updateUser(User oldUser, User newUser) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET email = ?, password = ?, genre = ? WHERE email = ?");
        preparedStatement.setString(1, newUser.getEmail());
        preparedStatement.setString(2, newUser.getPassword());
        preparedStatement.setString(3, newUser.getGenre());
        preparedStatement.setString(4, oldUser.getEmail());
        preparedStatement.executeUpdate();
    }

    //DELETE
    public void removeUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE email = ?");
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.executeUpdate();
    }
}
