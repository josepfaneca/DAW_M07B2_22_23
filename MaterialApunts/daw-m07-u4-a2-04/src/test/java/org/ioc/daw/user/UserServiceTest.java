package org.ioc.daw.user;

import org.ioc.daw.user.impl.UserServiceImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(Arquillian.class)
public class UserServiceTest {
    @Inject
    private UserService userService;

    @Deployment(testable = true)
    public static JavaArchive createTestableDeployment() {
        final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "example.jar")
                .addClasses(UserService.class, UserServiceImpl.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
        return jar;
    }

    @Test
    public void findUserByUsername() {
        String username = "jdoe";
        User user = new User();
        user.setActive(true);
        user.setCreatedOn(new Timestamp(new Date().getTime()));
        user.setEmail("test@test.com");
        user.setName("Jane");
        user.setPassword("password");
        user.setRank(100);
        user.setUsername(username);
        User user1 = new User();
        user1.setActive(true);
        user1.setCreatedOn(new Timestamp(new Date().getTime()));
        user1.setEmail("test1@test.com");
        user1.setName("Joe");
        user1.setPassword("password");
        user1.setRank(100);
        user1.setUsername("joeTest");

        userService.create(user);
        userService.create(user1);

        User userFromDB = userService.findUserByUsername(username);
        Assert.assertNotNull(userFromDB);
        Assert.assertEquals("jdoe", userFromDB.getUsername());
        Assert.assertEquals("test@test.com", userFromDB.getEmail());
        Assert.assertNotNull(userFromDB.getUserId());
    }
}
