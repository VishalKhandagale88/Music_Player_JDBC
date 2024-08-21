package dao;

import model.Playlist;

import java.sql.SQLException;

public interface PlayListDAO {
    void createPlayList(Playlist playlist) throws SQLException;
}
