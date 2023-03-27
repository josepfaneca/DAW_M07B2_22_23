/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author jfaneca
 */
public class DBConnTest {
    
    DBConnection dBConnection;
    
    Connection connection;
    private String connectionProperties = "db_test.properties";

    @Before
    public void setUp(){
        dBConnection = new DBConnection(connectionProperties);
    }

    @After
    public void cleanUp() throws SQLException {
        if(connection != null){
            connection.close();   
        }        
    }

    @Test
    //test amb db_test.properties
    public void dbConnection() throws IOException, SQLException {   
        connection = dBConnection.getConnection();
        Assert.assertEquals("H2 JDBC Driver", connection.getMetaData().getDriverName());
        Assert.assertEquals("XOLLOS_DB", connection.getCatalog());
    }
    
    @Test
    //test amb db_wrong_driver.properties
    public void dbConnectionWrongDriver() throws IOException, SQLException {  
        dBConnection = new DBConnection("db_wrong_driver.properties");
        connection = dBConnection.getConnection();
        Assert.assertNull(connection);
    }
    
    
    
}
