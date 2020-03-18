package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    Connection connection;

    public UserJdbcDAO() {
        this.connection = DBHelper.getInstance().getSqlConnection();
    }

    @Override
    public void addUser(User added) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO users(firstName, lastName, role) VALUES (?, ?, ?)");
            preparedStatement.setString(1, added.getFirstName());
            preparedStatement.setString(2, added.getPassword());
            preparedStatement.setString(3, added.getRole());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void deleteUser(User deleted) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE firstName = (?) AND lastName = (?)");
            preparedStatement.setString(1, deleted.getFirstName());
            preparedStatement.setString(2, deleted.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void updateUser(User updated) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET firstName = (?),lastName = (?), role = (?) WHERE id = (?)");
            preparedStatement.setString(1, updated.getFirstName());
            preparedStatement.setString(2, updated.getPassword());
            preparedStatement.setString(3, updated.getRole());
            preparedStatement.setLong(4, updated.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public List<User> getAllUser() {
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM users")) {
            List<User> allUser = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("password"));
                resultSet.getString("role");
                allUser.add(user);
            }
            return allUser;
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public User getUserById(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = (?)");
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            String firstName = resultSet.getString(2);
            String password = resultSet.getString(3);
            String role = resultSet.getString(4);
            preparedStatement.close();
            return new User(id, firstName, password, role);
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isExistUser(User verifiable) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE firstName = (?) AND password = (?)");
            preparedStatement.setString(1, verifiable.getFirstName());
            preparedStatement.setString(2, verifiable.getPassword());
            return true;
        } catch (SQLException e) {
            return false;
        }


    }

    @Override
    public User getUserByName(String firstName) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE firstName = (?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            Long id = resultSet.getLong(1);
            String password = resultSet.getString(3);
            String role = resultSet.getString(4);
            preparedStatement.close();
            return new User(id, firstName, password, role);
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String getRoleByUser(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE firstName = (?) AND password = (?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            String role = resultSet.getString(4);
            preparedStatement.close();
            return role;
        } catch (SQLException e) {
            throw new IllegalStateException("User is not exist");
        }
    }
}
