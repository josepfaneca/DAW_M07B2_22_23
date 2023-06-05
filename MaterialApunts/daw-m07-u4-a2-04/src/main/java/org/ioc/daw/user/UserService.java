package org.ioc.daw.user;

public interface UserService {
    public void create(User user);
    public void edit(User user);
    public void remove(User user);
    public User findUserByUsername(String username);
}
