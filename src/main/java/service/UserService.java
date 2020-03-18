package service;

import dao.*;
import model.User;

import java.sql.SQLException;
import java.util.List;

import dao.UserDaoFactory;

public class UserService {

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private UserDAO userDAO = UserDaoFactory.getUserDAO();

    public boolean addUser(User newUser) {
        userDAO.addUser(newUser);
        return true;
    }

    public boolean deleteUser(User deletedUser) {
        userDAO.deleteUser(deletedUser);
        return true;
    }

    public boolean updateUser(User updatedUser) {
        userDAO.updateUser(updatedUser);
        return true;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> result = null;
        result = userDAO.getAllUser();
        return result;
    }

    public User getUserById(long id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public boolean isExistUser(User verifiable) {
        return userDAO.isExistUser(verifiable);
    }

    public User getUserByName(String firstName) {
        return userDAO.getUserByName(firstName);
    }

    public String getRoleByUser(User user) throws java.lang.IndexOutOfBoundsException {
        return userDAO.getRoleByUser(user);
    }

}
