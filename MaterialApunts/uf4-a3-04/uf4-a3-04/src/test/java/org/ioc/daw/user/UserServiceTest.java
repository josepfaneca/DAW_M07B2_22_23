package org.ioc.daw.user;

import org.ioc.daw.config.SpringTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class})
public class UserServiceTest {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Test
    public void getUserByUsername() {
        String username = "test";
        User user = new User();
        user.setUsername(username);
        user.setUserId(1);

        when(userDAO.findUserByUsername(username)).thenReturn(user);

        User userResult = userService.getUser(username);
        assertEquals(username, userResult.getUsername());
        assertEquals(new Integer(1), userResult.getUserId());
        verify(userDAO, times(1)).findUserByUsername(username);
    }
}