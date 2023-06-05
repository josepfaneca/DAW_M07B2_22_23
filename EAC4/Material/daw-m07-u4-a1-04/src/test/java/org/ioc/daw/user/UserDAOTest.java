package org.ioc.daw.user;

import java.util.List;
import org.ioc.daw.db.DBConnection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
    private DBConnection dBConnection;
    private String connectionProperties = "db_test.properties";

    @Before
    public void setUp(){
        dBConnection = new DBConnection(connectionProperties);
    }
    
    @Test
    public void findAllUsers(){
        UserDAO userDAO = new UserDAO(dBConnection);
        List<User> users  = userDAO.findAllUsers();
        Assert.assertEquals("Hauriem de tenir 2 usuaris a la base de dades", 2, users.size());
    }
    
    @Test
    public void findUserByEmail() throws Exception{
        String existingEmail = "john@email.com";
        String unknownEmail = "does.not@exist.com";
        
        UserDAO userDAO = new UserDAO(dBConnection);
        User user = userDAO.findUserByEmail(existingEmail);
        Assert.assertNotNull(user);
        user = userDAO.findUserByEmail(unknownEmail);
        Assert.assertNull(user);
    }
    
    @Test
    public void findUserByUsername() throws Exception{
        String existingUsername = "user1";
        String unknownUsername = "unknown";
        
        UserDAO userDAO = new UserDAO(dBConnection);
        User user = userDAO.findUserByUsername(existingUsername);
        Assert.assertNotNull(user);
        user = userDAO.findUserByUsername(unknownUsername);
        Assert.assertNull(user);
    }
}
