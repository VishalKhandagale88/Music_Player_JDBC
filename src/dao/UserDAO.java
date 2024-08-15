package dao;

import model.User;

import java.sql.SQLException;

public interface UserDAO {
    void addUser(User user) throws SQLException;
    boolean validateUser(String name, String password) throws SQLException;

}
