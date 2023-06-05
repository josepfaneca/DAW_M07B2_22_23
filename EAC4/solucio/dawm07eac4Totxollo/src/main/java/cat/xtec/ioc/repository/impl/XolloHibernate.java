/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import org.hibernate.Criteria;
import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class XolloHibernate implements XolloRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Xollo getXolloByCodi(String codi) {
        return getSession().get(Xollo.class, codi);
    }

    @Override
    public List<Xollo> getAllXollos() {
        Criteria criteria = createEntityCriteria();
        return (List<Xollo>) criteria.list();
    }

    @Override
    public void addXollo(Xollo xollo) {        
        getSession().saveOrUpdate(xollo);
    }

    @Override
    public void updateXollo(Xollo xollo) {
        getSession().merge(xollo);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Xollo.class);
    }

}
