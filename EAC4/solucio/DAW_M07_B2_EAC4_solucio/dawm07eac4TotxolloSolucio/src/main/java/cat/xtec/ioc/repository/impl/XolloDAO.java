package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Xollo;
import cat.xtec.ioc.repository.XolloRepository;
import cat.xtec.ioc.service.impl.XolloServiceImpl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Germán
 */
//@Repository
public class XolloDAO implements XolloRepository {

    private Dbconnection dBConnection;
    private Connection connection;

    public XolloDAO(Dbconnection dBConnection) {
        try {
            this.dBConnection = dBConnection;
            connection = dBConnection.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(XolloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public XolloDAO() {
        try {
            dBConnection = new Dbconnection("db.properties");
            connection = dBConnection.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(XolloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Xollo getXolloByCodi(String codi) {
        String qry = "select * from xollos where codi = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(qry);
            preparedStatement.setString(1, codi);
            return findUniqueResult(preparedStatement);
        } catch (Exception ex) {
            Logger.getLogger(XolloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            createOrUpdateXollo(xollo.getCodi(), preparedStatement);
        } catch (Exception ex) {
            Logger.getLogger(XolloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Xollo> getAllXollos() {
        String qry = "select * from xollos";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(qry);
            List<Xollo> xollos = executeQuery(preparedStatement);
            return xollos;
        } catch (SQLException ex) {
            Logger.getLogger(XolloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Xollo createOrUpdateXollo(String codi, PreparedStatement preparedStatement) throws Exception {
        int result = executeUpdateQuery(preparedStatement);
        return getXolloByCodi(codi);
    }

    private Xollo findUniqueResult(PreparedStatement preparedStatement) throws Exception {
      
        List<Xollo> xollos = executeQuery(preparedStatement);
        if (xollos.isEmpty()) {
            return null;
        }
        if (xollos.size() > 1) {
            throw new Exception("Only one result expected");
        }
        return xollos.get(0);
    }

    private List<Xollo> executeQuery(PreparedStatement preparedStatement) {
      
        List<Xollo> xollos = new ArrayList<>();

        try (
                ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Xollo xollo = buildXolloFromResultSet(rs);
                xollos.add(xollo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xollos;
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

    private int executeUpdateQuery(PreparedStatement preparedStatement) {
        int result = 0;
        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        try {
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Xollo buildXolloFromResultSet(ResultSet rs) throws SQLException {
        
        String codi = rs.getString("codi");
        Integer numeroUnitats = rs.getInt("numeroUnitats");
        Integer numeroReserves = rs.getInt("numeroReserves");
        String titol = rs.getString("titol");
        String descripcio = rs.getString("descripcio");
        Xollo xollo = new Xollo(codi, numeroUnitats, numeroReserves, titol, descripcio);
        return xollo;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateXollo(Xollo xollo) {
        String qry = "DELETE FROM xollos WHERE codi = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(qry);
            preparedStatement.setString(1, xollo.getCodi());
            createOrUpdateXollo(xollo.getCodi(), preparedStatement);
            this.addXollo(xollo);
        } catch (Exception ex) {
            Logger.getLogger(XolloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

}
