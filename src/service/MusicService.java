package service;

import dao.PlayListDAOImpl;
import dao.SongDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Playlist;
import model.Song;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class MusicService {

    private UserDAOImpl userDAO = new UserDAOImpl();
    private SongDAOImpl songDAO = new SongDAOImpl();
    private PlayListDAOImpl playListDAO = new PlayListDAOImpl();

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }
    public boolean validateUser(String name, String password) throws SQLException{
        return userDAO.validateUser(name, password);
    }
    public List<Song> getAllSongs() throws SQLException{
        return songDAO.getAllSongs();
    }
    public void createPlaylist(Playlist playlist) throws SQLException {
        playListDAO.createPlayList(playlist);
    }
    public User getUserByName(String name) throws SQLException {
        return userDAO.getUserByName(name);
    }

}
