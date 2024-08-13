package dao;

import model.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// actual logic which interact with db
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users(username, password,email) VALUES(?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.userName);
            preparedStatement.setString(2, user.password);
            preparedStatement.setString(3, user.email);
            preparedStatement.executeUpdate();
        }
    }
}
