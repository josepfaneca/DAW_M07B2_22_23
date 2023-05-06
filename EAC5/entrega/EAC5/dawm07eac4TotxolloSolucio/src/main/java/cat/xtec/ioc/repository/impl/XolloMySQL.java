/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

/**
 *
 * @author German
 */
//@Repository
public class XolloMySQL implements XolloRepository {

    private EntityManager entityManager;

    public XolloMySQL(){
         entityManager  = Persistence.createEntityManagerFactory("XollosPersistenceUnit").createEntityManager();
    }
    
    @Override
    public Xollo getXolloByCodi(String codi) {
        return (Xollo) entityManager.createQuery("select object(o) from Xollo o " +
                "where o.codi = :codi")
                .setParameter("codi", codi)
                .getSingleResult();
    }

    @Override
    public List<Xollo> getAllXollos() {
        return (List<Xollo>) entityManager.createQuery("select object(o) from Xollo o ")
                  .getResultList();        
    }

    @Override
    public void addXollo(Xollo xollo) {
        entityManager.persist(xollo);    
    }

    @Override
    public void updateXollo(Xollo xollo) {
        entityManager.merge(xollo);   
    }

}
