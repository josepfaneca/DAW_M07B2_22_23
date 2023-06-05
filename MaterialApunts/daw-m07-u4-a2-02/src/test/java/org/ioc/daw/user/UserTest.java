package org.ioc.daw.user;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserTest {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Before
    public void setUp() {
        entityManager  = Persistence.createEntityManagerFactory("InMemoryH2PersistenceUnit").createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @After
    public void cleanUp() {
        entityManager.close();
    }

    @Test
    public void findAllUsers(){

        User user = new User();
        user.setActive(true);
        user.setCreatedOn(new Timestamp(new Date().getTime()));
        user.setEmail("test@test.com");
        user.setName("Jane");
        user.setPassword("password");
        user.setRank(100);
        user.setUsername("jdoe");
        user.setUserId(23L);

        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();

        Query query = entityManager.createNativeQuery("select * from users", User.class);
        List<User> userList = query.getResultList();
        Assert.assertEquals(1, userList.size());
        Assert.assertEquals("jdoe", userList.get(0).getUsername());
    }

}
