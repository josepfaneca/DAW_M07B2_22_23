/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jfaneca
 */

public class XolloDAO implements XolloRepository {

    private DBConnection dBConnection;
    private Connection connection;

    public XolloDAO(DBConnection dBConnection) {
        this.dBConnection = dBConnection;
    }

    @Override
    public void addXollo(Xollo xollo) {
        String qry = "INSERT INTO xollos (codi, numeroUnitats, numeroReserves, titol, descripcio) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement = getPreparedStatement(qry);
            preparedStatement.setString(1, xollo.getCodi());
            preparedStatement.setInt(2, xollo.getNumeroUnitats());
            preparedStatement.setInt(3, xollo.getNumeroReserves());
            preparedStatement.setString(4, xollo.getTitol());
            preparedStatement.setString(5, xollo.getDescripcio());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public Xollo getXolloByCodi(String codi) {
        String qry = "select * from xollos where codi =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(qry);
            preparedStatement.setString(1, codi);
            List<Xollo> xollo = executeQuery(preparedStatement);
            if (xollo.isEmpty()) {
                return null;
            } else {
                return xollo.get(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateXollo(Xollo xollo) {
        String qry = "UPDATE xollos SET numeroUnitats = ?, numeroReserves = ?, titol = ?, descripcio=? WHERE codi = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(qry);
            preparedStatement.setInt(1, xollo.getNumeroUnitats());
            preparedStatement.setInt(2, xollo.getNumeroReserves());
            preparedStatement.setString(3, xollo.getTitol());
            preparedStatement.setString(4, xollo.getDescripcio());
            preparedStatement.setString(5, xollo.getCodi());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Xollo> getAllXollos() {
        String qry = "select codi, numeroUnitats, numeroReserves, titol, descripcio from xollos";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(qry);
            List<Xollo> xollos = executeQuery(preparedStatement);
            return xollos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private PreparedStatement getPreparedStatement(String query) throws SQLException {
        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return getConnection().prepareStatement(query);
    }

    private List<Xollo> executeQuery(PreparedStatement preparedStatement) {
        List<Xollo> xollos = new ArrayList<>();
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Xollo xollo = buildXolloFromResultSet(rs);
                xollos.add(xollo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return xollos;
    }

    private Xollo buildXolloFromResultSet(ResultSet rs) throws SQLException {
        String codi = rs.getString("codi");
        Integer numeroUnitats = rs.getInt("numeroUnitats");
        Integer numeroReserves = rs.getInt("numeroReserves");
        String titol = rs.getString("titol");
        String descripcio = rs.getString("descripcio");

        Xollo cotxe = new Xollo(codi, numeroUnitats, numeroReserves, titol, descripcio);
        return cotxe;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
