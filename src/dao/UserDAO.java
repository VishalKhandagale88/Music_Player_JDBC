package dao;

import model.User;

import java.sql.SQLException;

public interface UserDAO {
    void addUser(User user) throws SQLException;
}
