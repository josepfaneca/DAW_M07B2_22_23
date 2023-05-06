package org.ioc.daw.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.ioc.daw.db.DBConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {

    private DBConnection dBConnection;
    private String connectionProperties = "db_test.properties";
    UserDAO userDAO;

    @Before
    public void setUp() {
        dBConnection = new DBConnection(connectionProperties);
        userDAO = new UserDAO(dBConnection);
    }

    @After
    public void tearDown() throws IOException, SQLException {
        userDAO.getConnection().close();
    }

    @Test
    public void findAllUsers() {
        List<User> users = userDAO.findAllUsers();
        Assert.assertEquals("Hauriem de tenir 2 usuaris a la base de dades", 2, users.size());
    }

    @Test
    public void findUserByEmail() throws Exception {
        String existingEmail = "john@email.com";
        String unknownEmail = "does.not@exist.com";

        User user = userDAO.findUserByEmail(existingEmail);
        Assert.assertNotNull(user);
        user = userDAO.findUserByEmail(unknownEmail);
        Assert.assertNull(user);
    }

    @Test
    public void findUserByUsername() throws Exception {
        String existingUsername = "user1";
        String unknownUsername = "unknown";

        User user = userDAO.findUserByUsername(existingUsername);
        Assert.assertNotNull(user);
        user = userDAO.findUserByUsername(unknownUsername);
        Assert.assertNull(user);
    }

    @Test
    public void createUser() throws Exception {
        String username = "testUser";
        String name = "Pete Test";
        String email = "pete@email.com";
        User createdUser = userDAO.createUser(username, name, email);
        Assert.assertNotNull(createdUser);
        Assert.assertEquals(username, createdUser.getUsername());
        Assert.assertNotEquals(0, createdUser.getUserId());
    }

    @Test(expected = Exception.class)
    public void createUserWithError() throws Exception {
        String username = "sl','sls";
        String name = "Pete Test";
        String email = "pete@email.com";
        User createdUser = userDAO.createUser(username, name, email);
        Assert.assertNull(createdUser);
    }


    @Test
    public void updateUserEmail() throws Exception {
        String username = "testUser";
        String name = "Pete Test";
        String email = "pete@email.com";
        User createdUser = userDAO.createUser(username, name, email);
        Assert.assertNotNull(createdUser);
        Assert.assertEquals(email, createdUser.getEmail());
        User updatedUser = userDAO.updateUserEmail(createdUser, "new@email.com");
        Assert.assertEquals(createdUser.getUserId(), updatedUser.getUserId());
        Assert.assertEquals("new@email.com", updatedUser.getEmail());
    }



}