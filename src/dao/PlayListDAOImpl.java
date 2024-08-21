package dao;

import model.Playlist;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayListDAOImpl implements PlayListDAO {
    @Override
    public void createPlayList(Playlist playlist) throws SQLException {
        String sql = "INSERT INTO playlists (name, user_id) VALUES (?,?)";
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,playlist.getName());
        preparedStatement.setInt(2,playlist.getUser().getUserId());
        preparedStatement.executeUpdate();
    }
}
