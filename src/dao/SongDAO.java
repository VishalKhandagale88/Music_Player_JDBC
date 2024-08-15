package dao;

import model.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongDAO {
    List<Song> getAllSongs() throws SQLException;
}
