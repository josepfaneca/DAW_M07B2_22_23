package org.ioc.daw.user;

import org.ioc.daw.config.EmbeddedDatabaseTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedDatabaseTestConfig.class})
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    @Transactional
    public void saveUser() {
        User user = new User();
        user.setUsername("test");
        user.setActive(true);
        user.setEmail("email@test.com");
        user.setPassword("password");
        user.setName("name");
        user.setRank(10);
        user.setCreatedOn(new Timestamp(new Date().getTime()));
        assertNull(user.getUserId());
        userDAO.create(user);
        assertNotNull(user.getUserId());
        user.setEmail("new-email@test.com");

        User userFromDb = userDAO.findUserByUsername("test");
        assertEquals(user.getUserId(), userFromDb.getUserId());
        assertEquals("new-email@test.com", userFromDb.getEmail());
    }
}