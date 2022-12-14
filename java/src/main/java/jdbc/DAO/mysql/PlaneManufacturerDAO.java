package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import jdbc.model.PlaneManufacturer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaneManufacturerDAO implements IBaseDAO<PlaneManufacturer> {

    private final String INSERT_MANUFACTURER = "INSERT INTO plane_manufacturers(manufacturer_name) " + "VALUES(?)";
    private final String GET_MANUFACTURER_BY_ID = "SELECT * FROM plane_manufacturers WHERE manufacturer_id = ?";
    private final String GET_ALL_MANUFACTURERS = "SELECT * FROM plane_manufacturers ORDER BY manufacturer_id";
    private final String DELETE_BY_ID = "DELETE FROM plane_manufacturers WHERE manufacturer_id = ?";
    private final String UPDATE_MANUFACTURER = "UPDATE plane_manufacturers SET manufacturer_name =  ? WHERE manufacturer_id = ?";
    private final String DELETE_ALL = "DELETE FROM plane_manufacturers";
    private final Logger LOGGER = LogManager.getLogger(PlaneManufacturerDAO.class);

    public PlaneManufacturerDAO() throws SQLException {
    }

    @Override
    public PlaneManufacturer getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_MANUFACTURER_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            PlaneManufacturer manufacturer = new PlaneManufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));

            return manufacturer;
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
    public ArrayList<PlaneManufacturer> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_MANUFACTURERS);

            ResultSet result = preparedStatement.executeQuery();

            ArrayList<PlaneManufacturer> manufacturers = new ArrayList<>();

            while (result.next()) {

                PlaneManufacturer manufacturer = new PlaneManufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));

                manufacturers.add(manufacturer);
            }

            return manufacturers;
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
    public void insertRow(PlaneManufacturer object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_MANUFACTURER);
            preparedStatement.setString(1, object.getManufacturerName());

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
    public void updateRow(int id, PlaneManufacturer object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_MANUFACTURER);
            preparedStatement.setString(1, object.getManufacturerName());
            preparedStatement.setInt(2, id);

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
