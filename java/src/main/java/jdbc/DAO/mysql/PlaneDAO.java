package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IPlaneDAO;
import jdbc.Plane;
import jdbc.Plane_Manufacturer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaneDAO implements IPlaneDAO {

    private final String INSERT_PLANE = "INSERT INTO planes(year,modelId) " + "VALUES(?,?)";
    private final String GET_PLANE_BY_ID = "SELECT * FROM planes LEFT JOIN plane_models ON planes.modelId = plane_models.model_id LEFT JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id  WHERE plane_id = ?";
    private final String GET_ALL_PLANES = "SELECT * FROM planes INNER JOIN plane_models ON planes.modelId = plane_models.model_id INNER JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id LEFT JOIN flights ON planes.plane_id = flights.planeId ORDER BY plane_id";
    private final String DELETE_BY_ID = "DELETE FROM planes WHERE plane_id = ?";
    private final String UPDATE_PLANE = "UPDATE planes SET year =  ? , modelId = ?";
    private final Logger LOGGER = LogManager.getLogger(PlaneDAO.class);

    public PlaneDAO() throws SQLException {
    }

    @Override
    public Plane getPlaneById(long id) throws SQLException {
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
            Plane_Manufacturer manufacturer = new Plane_Manufacturer(plane.getInt("manufacturer_id"), plane.getString("manufacturer_name"));
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
    public ArrayList<Plane> getAllPlanes() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            ArrayList<Plane> planeList = new ArrayList<>();

            preparedStatement = connection.prepareStatement(GET_ALL_PLANES);
            ResultSet planes = preparedStatement.executeQuery();

            while (planes.next()) {
                Plane_Manufacturer manufacturer = new Plane_Manufacturer(planes.getInt("manufacturer_id"), planes.getString("manufacturer_name"));
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
    public void insertPlane(int year, int model) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_PLANE);
            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, model);
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
    public void updatePlane(Plane plane) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_PLANE);

            preparedStatement.setInt(1, plane.getPlaneId());
            preparedStatement.setInt(2, plane.getModelId());
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
    public void deletePlane(long planeId) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1, planeId);

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
