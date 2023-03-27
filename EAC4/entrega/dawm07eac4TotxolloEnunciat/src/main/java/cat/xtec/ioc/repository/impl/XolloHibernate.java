/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author jfaneca
 */
@Transactional //La notació @Transactional indica que els mètodes definits a la classe utilitzaran transaccions
@Repository("xolloHibernate")//indica que quan la classe sigui escanejada per Spring es crearà un bean anomenat xolloHibernate
public class XolloHibernate implements XolloRepository {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addXollo(Xollo xollo) {
        getSession().saveOrUpdate(xollo);
    }

    @Override
    public Xollo getXolloByCodi(String codi) {
        System.out.println("Get xollo Hibernate");
        return getSession().get(Xollo.class, codi);
    }

    @Override
    public void updateXollo(Xollo xollo) {
        getSession().merge(xollo);
    }

    @Override
    public List<Xollo> getAllXollos() {
        Criteria criteria = createEntityCriteria();
        return (List<Xollo>) criteria.list();
    }
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Xollo.class);
    }
    
}
