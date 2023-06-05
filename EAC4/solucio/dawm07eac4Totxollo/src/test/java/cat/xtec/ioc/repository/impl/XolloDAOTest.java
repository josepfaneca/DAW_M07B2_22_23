package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XolloDAOTest {

    private Dbconnection dBConnection;
    private String connectionProperties = "db_test.properties";
    XolloDAO xolloDAO;

    @Before
    public void setUp() {
        dBConnection = new Dbconnection(connectionProperties);
        xolloDAO = new XolloDAO(dBConnection);
    }

    @After
    public void tearDown() throws IOException, SQLException {
        xolloDAO.getConnection().close();
    }

    
    @Test
    public void getSubsidiByCodi() throws Exception {
        String existingCodi = "0";
        String unknownCodi = "7";

        Xollo xollo = xolloDAO.getXolloByCodi(existingCodi);
        Assert.assertNotNull(xollo);
        xollo = xolloDAO.getXolloByCodi(unknownCodi);
        Assert.assertNull(xollo);
    }
    
    @Test
    public void getAllXollos() throws SQLException {
        List<Xollo> xollos = xolloDAO.getAllXollos();
        Assert.assertEquals("Hauriem de tenir 6 xollos a la base de dades", 6, xollos.size());
    }
    
    @Test
    public void addXollo() throws Exception {
        String codi = "7";
        String titol = "Article7";
        Integer numUnitats = 22;
        Integer numReserves = 0;
        String descripcio = "Coses relatives a l'article 7";
        Xollo xollo = new Xollo(codi, numUnitats, numReserves, titol, descripcio);
        xolloDAO.addXollo(xollo);
        Xollo createdXollo = xolloDAO.getXolloByCodi(codi);
        Assert.assertNotNull(createdXollo);        
    }
    
    @Test
    public void updateXollo() throws Exception {
        String nouTitol = "NOU TITOL";
        Xollo xollo = xolloDAO.getXolloByCodi("0");
        Assert.assertNotNull(xollo);
        xollo.setTitol(nouTitol);
        xolloDAO.updateXollo(xollo);
        Xollo updatedXollo = xolloDAO.getXolloByCodi(xollo.getCodi());
        Assert.assertEquals(nouTitol, updatedXollo.getTitol());        
    }

}
