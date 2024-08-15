package dao;

import model.Song;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDAOImpl implements SongDAO {
    @Override
    public List<Song> getAllSongs() throws SQLException {
        String sql = "SELECT * FROM song";
        List<Song> allSongs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                allSongs.add(new Song(resultSet.getInt("song_id"), resultSet.getString("title"), resultSet.getString("artist"), resultSet.getString("path")));
            }
        }
        return allSongs;
    }
}
