package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.sql.SQLException;

public class MusicService {

    private UserDAO userDAO = new UserDAOImpl();

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }
}
