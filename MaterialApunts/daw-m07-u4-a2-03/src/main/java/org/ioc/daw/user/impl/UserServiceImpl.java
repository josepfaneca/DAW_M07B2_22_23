package org.ioc.daw.user.impl;


import org.ioc.daw.user.User;
import org.ioc.daw.user.UserService;

import javax.persistence.EntityManager;

public class UserServiceImpl implements UserService {
    private EntityManager entityManager;

    public UserServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return (User) entityManager.createQuery("select object(o) from User o " +
                                      "where o.username = :username")
                                      .setParameter("username", username)
                                      .getSingleResult();
    }
}
