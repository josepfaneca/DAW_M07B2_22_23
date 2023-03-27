/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jfaneca
 */
public class XolloMySQLTest {

    public XolloMySQLTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //entityManager = Persistence.createEntityManagerFactory("XollosPersistenceUnit").createEntityManager();
        //entityTransaction = entityManager.getTransaction();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addXollo method, of class XolloMySQL.
     */
    @Test
    public void testAddXollo() {
        System.out.println("addXollo");
        Xollo xollo = new Xollo("100", 10, 0, "test_XolloMysql", "insertar un xollo de prova");
        //XolloMySQL instance = new XolloMySQL();
        //System.out.println("addXollo");
        /*instance.addXollo(xollo);
        Xollo xolloTest = instance.getXolloByCodi("100");
        Assert.assertEquals("100", xolloTest.getCodi());*/
    }

    /**
     * Test of getXolloByCodi method, of class XolloMySQL.
     */
    @Test
    public void testGetXolloByCodi() {
        /*System.out.println("getXolloByCodi");
        String codi = "";
        XolloMySQL instance = new XolloMySQL();
        Xollo expResult = null;
        Xollo result = instance.getXolloByCodi(codi);
        assertEquals(expResult, result);*/
    }

    /**
     * Test of updateXollo method, of class XolloMySQL.
     */
    @Test
    public void testUpdateXollo() {
        /*System.out.println("updateXollo");
        XolloMySQL instance = new XolloMySQL();
        Xollo xollo = instance.getXolloByCodi("101");
        xollo.setTitol("titol canviat test");
        instance.updateXollo(xollo);
        xollo = instance.getXolloByCodi("101");
        Assert.assertEquals("titol canviat test", xollo.getDescripcio());*/
    }

    /**
     * Test of getAllXollos method, of class XolloMySQL.
     */
    @Test
    public void testGetAllXollos() {
        /*System.out.println("getAllXollos");
        XolloMySQL instance = new XolloMySQL();
        List<Xollo> result = instance.getAllXollos();
        Assert.assertEquals(7, result.size());*/
    }

}
