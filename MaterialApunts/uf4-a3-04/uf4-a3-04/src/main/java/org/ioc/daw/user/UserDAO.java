package org.ioc.daw.user;

import java.util.List;

public interface UserDAO {
    public void create(User user);
    public User edit(User user);
    public void remove(User user);
    public User findUserByUsername(String username);
    public User findUserWithHighestRank();
    public List<User> findActiveUsers();
}
