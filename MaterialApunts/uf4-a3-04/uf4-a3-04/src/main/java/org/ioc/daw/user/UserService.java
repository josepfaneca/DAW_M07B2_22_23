package org.ioc.daw.user;


public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser(String username) {
        return userDAO.findUserByUsername(username);
    }
}
