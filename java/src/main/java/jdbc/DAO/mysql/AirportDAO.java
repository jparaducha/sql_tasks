package jdbc.DAO.mysql;

import jdbc.Airport;
import jdbc.City;
import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirportDAO implements IBaseDAO<Airport> {

    private final String INSERT_AIRPORT = "INSERT INTO airports(airport_name, IATA_code, cityId) " + "VALUES(?, ?, ?)";
    private final String GET_AIRPORT_BY_ID = "SELECT * FROM airports LEFT JOIN cities ON airports.cityId = cities.city_id WHERE airport_id = ? ORDER BY airport_id";
    private final String GET_ALL_AIRPORTS = "SELECT * FROM airports LEFT JOIN cities ON airports.cityId = cities.city_id ORDER BY airport_id";
    private final String DELETE_BY_ID = "DELETE FROM airports WHERE airport_id = ?";
    private final String UPDATE_AIRPORT = "UPDATE airports SET airport_name =  ?, IATA_code = ?, cityId = ? WHERE airport_id = ?";
    private final String DELETE_ALL = "DELETE FROM airports";
    private final Logger LOGGER = LogManager.getLogger(AirportDAO.class);

    public AirportDAO() throws SQLException {
    }

    @Override
    public Airport getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_AIRPORT_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();


            City city = new City(result.getInt("city_id"), result.getString("city_name"));
            Airport airport = new Airport(result.getInt("airport_id"), result.getString("airport_name"), result.getString("IATA_code"), city);

            return airport;
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
    public ArrayList<Airport> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_AIRPORTS);

            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Airport> airports = new ArrayList<>();

            while (result.next()) {
                City city = new City(result.getInt("city_id"), result.getString("city_name"));
                Airport airport = new Airport(result.getInt("airport_id"), result.getString("airport_name"), result.getString("IATA_code"), city);

                airports.add(airport);
            }
            return airports;
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
    public void insertRow(Airport object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_AIRPORT);

            preparedStatement.setString(1, object.getAirport_name());
            preparedStatement.setString(2, object.getIATA_code());
            preparedStatement.setInt(3, object.getCity().getCity_id());

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
    public void updateRow(int id, Airport object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_AIRPORT);
            preparedStatement.setString(1, object.getAirport_name());
            preparedStatement.setString(2, object.getIATA_code());
            preparedStatement.setInt(3, object.getCity().getCity_id());
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
