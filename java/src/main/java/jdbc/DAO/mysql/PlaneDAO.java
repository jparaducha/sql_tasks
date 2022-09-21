package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import jdbc.Plane;
import jdbc.PlaneManufacturer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaneDAO implements IBaseDAO<Plane> {

    private final String INSERT_PLANE = "INSERT INTO planes(year,modelId) " + "VALUES(?,?)";
    private final String GET_PLANE_BY_ID = "SELECT * FROM planes LEFT JOIN plane_models ON planes.modelId = plane_models.model_id LEFT JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id  WHERE plane_id = ?";
    private final String GET_ALL_PLANES = "SELECT * FROM planes INNER JOIN plane_models ON planes.modelId = plane_models.model_id INNER JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id LEFT JOIN flights ON planes.plane_id = flights.planeId ORDER BY plane_id";
    private final String DELETE_BY_ID = "DELETE FROM planes WHERE plane_id = ?";
    private final String UPDATE_PLANE = "UPDATE planes SET year =  ? , modelId = ?";
    private final String DELETE_ALL = "DELETE FROM planes";
    private final Logger LOGGER = LogManager.getLogger(PlaneDAO.class);

    public PlaneDAO() throws SQLException {
    }

    @Override
    public Plane getById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(GET_PLANE_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet plane = preparedStatement.executeQuery();

            if (!plane.next()) {
                return null;
            }
            PlaneManufacturer manufacturer = new PlaneManufacturer(plane.getInt("manufacturer_id"), plane.getString("manufacturer_name"));
            Plane plane1 = new Plane(plane.getInt("plane_id"), plane.getInt("year"), plane.getString(plane.findColumn("model_name")), manufacturer);

            return plane1;
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
    public ArrayList<Plane> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            ArrayList<Plane> planeList = new ArrayList<>();

            preparedStatement = connection.prepareStatement(GET_ALL_PLANES);
            ResultSet planes = preparedStatement.executeQuery();

            while (planes.next()) {
                PlaneManufacturer manufacturer = new PlaneManufacturer(planes.getInt("manufacturer_id"), planes.getString("manufacturer_name"));
                planeList.add(new Plane(planes.getInt("plane_id"), planes.getInt("year"), planes.getString(planes.findColumn("model_name")), manufacturer));
            }

            return planeList;
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
    public void insertRow(Plane object) throws SQLException {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_PLANE);
            preparedStatement.setInt(1, object.getYear());
            preparedStatement.setString(2, object.getModel());
            int rs = preparedStatement.executeUpdate();
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
    public void updateRow(int id, Plane object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_PLANE);

            preparedStatement.setInt(1, object.getPlaneId());
            preparedStatement.setString(2, object.getModel());
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

