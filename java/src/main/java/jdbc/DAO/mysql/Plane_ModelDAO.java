package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import jdbc.Plane_Manufacturer;
import jdbc.Plane_Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Plane_ModelDAO implements IBaseDAO<Plane_Model> {

    private final String INSERT_MODEL = "INSERT INTO plane_models(model_name, manufacturer) " + "VALUES(?,?)";
    private final String GET_MODEL_BY_ID = "SELECT * FROM plane_models JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id WHERE model_id = ?";
    private final String GET_ALL_MODELS = "SELECT * FROM plane_manufacturers ORDER BY model_id";
    private final String DELETE_BY_ID = "DELETE FROM plane_manufacturers WHERE model_id = ?";
    private final String UPDATE_MODEL = "UPDATE plane_manufacturers SET model_name =  ? , manufacturer = ? WHERE model_id = ?";
    private final String DELETE_ALL = "DELETE FROM plane_manufacturers";
    private final Logger LOGGER = LogManager.getLogger(Plane_ModelDAO.class);

    public Plane_ModelDAO() throws SQLException {
    }

    @Override
    public Plane_Model getById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_MODEL_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));
            Plane_Model model = new Plane_Model(result.getInt("model_id"), result.getString("model_name"), manufacturer);

            return model;
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
    public ArrayList<Plane_Model> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_MODELS);

            ArrayList<Plane_Model> models = new ArrayList<>();
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));
                Plane_Model model = new Plane_Model(result.getInt("model_id"), result.getString("model_name"), manufacturer);
                models.add(model);
            }

            return models;
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
    public void insertRow(Plane_Model object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(INSERT_MODEL);
            preparedStatement.setString(1, object.getModel_name());
            preparedStatement.setInt(2, object.getManufacturer().getManufacturer_id());

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
    public void updateRow(int id, Plane_Model object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_MODEL);
            preparedStatement.setString(1, object.getModel_name());
            preparedStatement.setInt(2, object.getManufacturer().getManufacturer_id());
            preparedStatement.setInt(3, id);

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
