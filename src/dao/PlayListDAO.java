package dao;

import model.Playlist;

import java.sql.SQLException;
import java.util.List;

public interface PlayListDAO {
    void createPlayList(Playlist playlist) throws SQLException;
    List<Playlist> getAllPlaylists(int userId) throws SQLException;
    void addSongToPlayList(int playlist_id, int song_id) throws SQLException;
}
