package service;

import dao.SongDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Song;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class MusicService {

    private UserDAO userDAO = new UserDAOImpl();
    private SongDAOImpl songDAO = new SongDAOImpl();

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }
    public boolean validateUser(String name, String password) throws SQLException{
        return userDAO.validateUser(name, password);
    }
    public List<Song> getAllSongs() throws SQLException{
        return songDAO.getAllSongs();
    }

}
