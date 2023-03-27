package org.ioc.daw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    DBConnection dBConnection;
    Connection connection;

    @Before
    public void setUp(){
        dBConnection = new DBConnection();
    }

    @After
    public void cleanUp() throws SQLException {
        connection.close();
    }

    @Test
    public void connectarAmbLaBaseDeDades() throws IOException, SQLException {
        connection = dBConnection.getConnection();
        Assert.assertEquals("H2 JDBC Driver", connection.getMetaData().getDriverName());
        Assert.assertEquals("SOCIOC_DB", connection.getCatalog());
    }
}
    