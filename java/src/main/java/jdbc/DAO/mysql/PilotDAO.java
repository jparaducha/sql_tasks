package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import jdbc.model.Pilot;
import jdbc.model.PilotLicense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class PilotDAO implements IBaseDAO<Pilot> {

    private final String INSERT_PILOT = "INSERT INTO pilots(pilot_name, pilot_age, licenseId) " + "VALUES(?,?,?)";
    private final String GET_PILOT_BY_ID = "SELECT * FROM pilots LEFT JOIN pilot_licenses ON pilots.licenseId = pilot_licenses.license_id WHERE id_pilot = ?";
    private final String GET_ALL_PILOTS = "SELECT * FROM pilots ORDER BY id_pilot";
    private final String DELETE_BY_ID = "DELETE FROM pilots WHERE id_pilot = ?";
    private final String UPDATE_PILOT = "UPDATE pilots SET pilot_name =  ?, pilot_age = ?, licenseId = ? WHERE id_pilot = ?";
    private final String DELETE_ALL = "DELETE FROM pilots";
    private final Logger LOGGER = LogManager.getLogger(PilotDAO.class);
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");

    public PilotDAO() throws SQLException {
    }

    @Override
    public Pilot getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_PILOT_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            PilotLicense license = new PilotLicense(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

            Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

            return pilot;
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
    public ArrayList<Pilot> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_PILOTS);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Pilot> pilots = new ArrayList<>();

            while (result.next()) {

                PilotLicense license = new PilotLicense(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

                Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

                pilots.add(pilot);
            }

            return pilots;
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
    public void insertRow(Pilot object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(INSERT_PILOT);
            preparedStatement.setString(1, object.getPilotName());
            preparedStatement.setInt(2, object.getPilotAge());
            preparedStatement.setInt(3, object.getLicense().getLicenseId());

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
    public void updateRow(int id, Pilot object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_PILOT);
            preparedStatement.setString(1, object.getPilotName());
            preparedStatement.setInt(2, object.getPilotAge());
            preparedStatement.setInt(3, object.getLicense().getLicenseId());
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
