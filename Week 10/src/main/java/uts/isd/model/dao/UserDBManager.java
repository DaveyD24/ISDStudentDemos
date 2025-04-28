package uts.isd.model.dao;

import org.sqlite.core.DB;
import uts.isd.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBManager extends DBManager<User> {
    public int getUserCount() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
        resultSet.next();
        return resultSet.getInt(1);
    }

    public UserDBManager(Connection connection) throws SQLException {
        super(connection);
    }

    //CREATE
    public User add(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (Email, Password, Genre) VALUES (?, ?, ?)");
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getGenre());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("SELECT MAX(UserId) FROM USERS");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int userId = resultSet.getInt(1);
        user.setId(userId);
        return user;
    }

    public User get(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE UserId = ?");
        preparedStatement.setInt(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
    }

    //UPDATE
    public void update(User oldUser, User newUser) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USERS SET Email = ?, Password = ?, Genre = ? WHERE UserId = ?");
        preparedStatement.setString(1, newUser.getEmail());
        preparedStatement.setString(2, newUser.getPassword());
        preparedStatement.setString(3, newUser.getGenre());
        preparedStatement.setInt(4, oldUser.getId());
        preparedStatement.executeUpdate();
    }

    //DELETE
    public void delete(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE UserId = ?");
        preparedStatement.setInt(1, user.getId());
        preparedStatement.executeUpdate();
    }
}
