/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author German
 */
public class DBConnTest {
    Dbconnection dBConnection;
    Connection connection;
    private String connectionProperties = "db_test.properties";

    @Before
    public void setUp() {
        dBConnection = new Dbconnection(connectionProperties);
    }

    @After
    public void cleanUp() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void dbConnection() throws IOException, SQLException {
        connection = dBConnection.getConnection();
        Assert.assertEquals("H2 JDBC Driver", connection.getMetaData().getDriverName());
        Assert.assertEquals("XOLLOS_DB", connection.getCatalog());
    }

    @Test
    public void dbConnectionWrongDriver() throws IOException, SQLException {
        dBConnection = new Dbconnection("db_wrong_driver.properties");
        connection = dBConnection.getConnection();
        Assert.assertNull(connection);
    }
}
