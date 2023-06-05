/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author jfaneca
 */
public class XollosDAOTest {

    private DBConnection dBConnection;

    private String connectionProperties = "db_test.properties";

    XolloDAO xolloDAO;

    @Before
    public void setUp() {
        dBConnection = new DBConnection(connectionProperties);
        xolloDAO = new XolloDAO(dBConnection);
    }

    @After
    public void tearDown() throws IOException, SQLException {
        xolloDAO.getConnection().close();
    }

    @Test
    public void findAllXollo() {
        List<Xollo> xollos = xolloDAO.getAllXollos();
        Assert.assertEquals("Hauriem de tenir 6 xollos a la base de dades ", 6, xollos.size());
        Assert.assertNotEquals("Hauriem de tenir 0 xollos a la base de dades ", 0, xollos.size());
    }

    @Test
    public void findXolloById() throws Exception {
        String existingId = "0";
        String unknownId = "0001";

        Xollo xollo = xolloDAO.getXolloByCodi(existingId);
        Assert.assertNotNull(xollo);

        xollo = xolloDAO.getXolloByCodi(unknownId);
        Assert.assertNull(xollo);

    }

    @Test
    public void createXollo() throws Exception {
        String codi = "10";
        Integer numeroUnitats = 20;
        Integer numeroReserves = 0;
        String titol = "Xollo10";
        String descripcio = "Descripcio10";

        xolloDAO.addXollo(new Xollo(codi, numeroUnitats, numeroReserves, titol, descripcio));
        Xollo createdXollo = xolloDAO.getXolloByCodi(codi);

        Assert.assertNotNull(createdXollo);
        Assert.assertEquals(titol, createdXollo.getTitol());
        Assert.assertNotEquals("0", createdXollo.getCodi());

    }
    
    @Test
    public void createXolloWithError() throws Exception {
        String codi = null;
        Integer numeroUnitats = 20;
        Integer numeroReserves = 0;
        String titol = "XolloTest";
        String descripcio = "DescripcioTest";
        
        xolloDAO.addXollo(new Xollo(codi, numeroUnitats, numeroReserves, titol, descripcio));
        Xollo createdXollo = xolloDAO.getXolloByCodi(codi);
        Assert.assertNull(createdXollo);
       
    }
   
    @Test
    public void updateXolloTitol() throws Exception {
        Xollo xollo = xolloDAO.getXolloByCodi("1");
        xollo.setTitol("Xollo1_updated");
        xolloDAO.updateXollo(xollo);
        Assert.assertEquals("Xollo1_updated", xollo.getTitol());
        
    }
    
    
    
    

}
