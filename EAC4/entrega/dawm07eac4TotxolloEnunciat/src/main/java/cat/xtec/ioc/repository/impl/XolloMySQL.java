/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jfaneca
 */

public class XolloMySQL implements XolloRepository {

    private EntityManager entityManager;

    public XolloMySQL() {
       
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("XollosPersistenceUnit");
        Map<String, Object> properties = entityManagerFactory.getProperties();
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addXollo(Xollo xollo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(xollo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Xollo getXolloByCodi(String codi) {

        return (Xollo) entityManager.createQuery("select object(o) from Xollos o "
                + "where o.codi = :codi")
                .setParameter("codi", codi)
                .getSingleResult();
    }

    @Override
    public void updateXollo(Xollo xollo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(xollo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();

        }
    }

    @Override
    public List<Xollo> getAllXollos() {
        return (List<Xollo>) entityManager.createQuery("select object(o) from Xollos o ").getResultList();
    }

}
