package jdbc.DAO.mysql;

import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import jdbc.model.Airline;
import jdbc.model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirlineDAO implements IBaseDAO<Airline> {

    private final String INSERT_AIRLINE = "INSERT INTO airlines(airline_name, countryId) " + "VALUES(?,?)";
    private final String GET_AIRLINE_BY_ID = "SELECT * FROM airlines LEFT JOIN countries ON airlines.countryId = countries.country_id WHERE airline_id = ?";
    private final String GET_ALL_AIRLINES = "SELECT * FROM airlines LEFT JOIN countries ON countries.country_id = airlines.countryId ORDER BY airline_id";
    private final String DELETE_BY_ID = "DELETE FROM airlines WHERE airline_id = ?";
    private final String UPDATE_AIRLINE = "UPDATE airlines SET airline_name =  ?, countryId = ? WHERE airline_id = ?";
    private final String DELETE_ALL = "DELETE FROM airlines";
    private final Logger LOGGER = LogManager.getLogger(AirlineDAO.class);

    private final String GET_BY_COUNTRY_ID = "SELECT * FROM airlines RIGHT JOIN countries ON airlines.countryId = countries.country_id WHERE countries.country_id = ?";

    public AirlineDAO() throws SQLException {
    }

    @Override
    public Airline getById(int id) throws SQLException {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_AIRLINE_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();

            Country country = new Country();
            country.setCountryName(result.getString("country_name"));
            Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country);

            return airline;
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
    public ArrayList<Airline> getAll() throws SQLException {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_AIRLINES);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Airline> airlines = new ArrayList<>();

            while (result.next()) {

                Country country = new Country();
                country.setCountryName(result.getString("country_name"));
                Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country);

                airlines.add(airline);
            }

            return airlines;
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
    public void insertRow(Airline object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_AIRLINE);
            preparedStatement.setString(1, object.getAirlineName());
            preparedStatement.setInt(2, object.getCountry().getCountryId());

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
    public void updateRow(int id, Airline object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_AIRLINE);
            preparedStatement.setString(1, object.getAirlineName());
            preparedStatement.setInt(2, object.getCountry().getCountryId());
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

    public ArrayList<Airline> getByCountryId(int id) {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_BY_COUNTRY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Airline> airlines = new ArrayList<>();

            while (result.next()) {

                Country country = new Country();
                country.setCountryName(result.getString("country_name"));
                Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country);

                airlines.add(airline);
            }

            return airlines;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
                return null;
            }
        }
    }
}
