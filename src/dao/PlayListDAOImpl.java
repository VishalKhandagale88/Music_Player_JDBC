package dao;

import model.Playlist;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayListDAOImpl implements PlayListDAO {
    @Override
    public void createPlayList(Playlist playlist) throws SQLException {
        String sql = "INSERT INTO playlists (name, user_id) VALUES (?,?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, playlist.getName());
            preparedStatement.setInt(2, playlist.getUser().getUserId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Playlist> getAllPlaylists(int userId) throws SQLException {
        List<Playlist> usersPlayList = new ArrayList<>();
        String sql = "SELECT * FROM playlists where user_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Playlist playlist = new Playlist(resultSet.getInt("playlist_id"), resultSet.getString("name"));
            usersPlayList.add(playlist);
        }
        return usersPlayList;
    }

    @Override
    public void addSongToPlayList(int playlist_id, int song_id) throws SQLException {
        String sql = "INSERT INTO playlist_songs (playlist_id,song_id) VALUES (?,?)";
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,playlist_id);
        preparedStatement.setInt(2,song_id);
        preparedStatement.executeUpdate();
    }
}
