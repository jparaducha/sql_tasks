package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import jdbc.PilotLicense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PilotLicenseDAO implements IBaseDAO<PilotLicense> {

    private final String INSERT_PILOTLICENSE = "INSERT INTO pilot_licenses(issued_on, expires, pilotId) " + "VALUES(?,?,?)";
    private final String GET_PILOTLICENSE_BY_ID = "SELECT * FROM pilot_licenses WHERE license_id = ?";
    private final String GET_ALL_PILOTLICENSES = "SELECT * FROM pilot_licenses ORDER BY license_id";
    private final String DELETE_BY_ID = "DELETE FROM pilot_licenses WHERE license_id = ?";
    private final String UPDATE_PILOTLICENSE = "UPDATE pilot_licenses SET issued_on =  ?, expires = ?, pilotId = ? WHERE license_id = ?";
    private final String DELETE_ALL = "DELETE FROM pilot_licenses";
    private final Logger LOGGER = LogManager.getLogger(PilotLicenseDAO.class);
    PreparedStatement preparedStatement;

    public PilotLicenseDAO() throws SQLException {
    }

    @Override
    public PilotLicense getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_PILOTLICENSE_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            PilotLicense license;

            result.next();
            license = new PilotLicense(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

            return license;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public ArrayList<PilotLicense> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_PILOTLICENSES);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<PilotLicense> licenses = new ArrayList<>();
            PilotLicense license;

            while (result.next()) {
                license = new PilotLicense(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

                licenses.add(license);
            }

            return licenses;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void insertRow(PilotLicense object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_PILOTLICENSE);
            preparedStatement.setString(1, object.getIssued_on());
            preparedStatement.setString(2, object.getExpires());
            preparedStatement.setInt(3, object.getPilot_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void updateRow(int id, PilotLicense object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_PILOTLICENSE);
            preparedStatement.setString(1, object.getIssued_on());
            preparedStatement.setString(2, object.getExpires());
            preparedStatement.setInt(3, object.getPilot_id());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void deleteAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(DELETE_ALL);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }
}
