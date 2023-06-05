package org.ioc.daw.user;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository("userHibernateDAO")
public class UserHibernateDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public User edit(User user) {
        return (User) getSession().merge(user);
    }

    @Override
    public void remove(User user) {
        getSession().delete(user);
    }

    @Override
    public User findUserByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User findUserWithHighestRank() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.desc("rank"));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> findActiveUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("active", true));
        return (List<User>) criteria.list();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(User.class);
    }
}