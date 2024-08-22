package service;

import dao.PlayListDAOImpl;
import dao.SongDAOImpl;
import dao.UserDAOImpl;
import model.Playlist;
import model.Song;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class MusicService {

    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final SongDAOImpl songDAO = new SongDAOImpl();
    private final PlayListDAOImpl playListDAO = new PlayListDAOImpl();

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    public boolean validateUser(String name, String password) throws SQLException {
        return userDAO.validateUser(name, password);
    }

    public List<Song> getAllSongs() throws SQLException {
        return songDAO.getAllSongs();
    }

    public void createPlaylist(Playlist playlist) throws SQLException {
        playListDAO.createPlayList(playlist);
    }

    public User getUserByName(String name) throws SQLException {
        return userDAO.getUserByName(name);
    }

    public List<Playlist> getAllPlaylists(int userId) throws SQLException {
        return playListDAO.getAllPlaylists(userId);
    }

    public void addSongToPlayList(int playlist_id, int song_id) throws SQLException {
        playListDAO.addSongToPlayList(playlist_id, song_id);
    }

}
