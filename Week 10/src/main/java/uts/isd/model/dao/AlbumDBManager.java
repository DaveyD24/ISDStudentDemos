package uts.isd.model.dao;

import uts.isd.model.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class AlbumDBManager extends DBManager<Album> {
    public AlbumDBManager(Connection connection) throws SQLException {
        super(connection);
    }

    public Album add(Album album) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ALBUMS (Artist, Title) VALUES (?, ?)");
        preparedStatement.setString(1, album.getArtist());
        preparedStatement.setString(2, album.getTitle());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("SELECT MAX(UserId) FROM USERS");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int albumId = resultSet.getInt(1);
        album.setId(albumId);
        return album;
    }

    public Album get(Album album) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALBUMS WHERE AlbumId = ?");
        preparedStatement.setInt(1, album.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Album(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    }

    public void update(Album oldAlbum, Album newAlbum) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ALBUMS SET Artist = ?, Title = ? WHERE AlbumId = ?");
        preparedStatement.setString(1, newAlbum.getArtist());
        preparedStatement.setString(2, newAlbum.getTitle());
        preparedStatement.setInt(3, oldAlbum.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Album album) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ALBUMS WHERE AlbumId = ?");
        preparedStatement.setInt(1, album.getId());
        preparedStatement.executeUpdate();
    }

    public LinkedList<Album> allAlbums() throws SQLException {
        LinkedList<Album> albums = new LinkedList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALBUMS");
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            albums.add(new Album(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }
        return albums;
    }
}
