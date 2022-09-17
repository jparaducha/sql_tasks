package jdbc.DAO.mysql;

import jdbc.City;
import jdbc.Country;
import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CityDAO implements IBaseDAO<City> {

    private final String INSERT_CITY = "INSERT INTO cities(city_name, countryId) " + "VALUES(?,?)";
    private final String GET_CITY_BY_ID = "SELECT * FROM cities LEFT JOIN countries ON countries.country_id = cities.countryId WHERE city_id = ?";
    private final String GET_ALL_CITIES = "SELECT * FROM cities LEFT JOIN countries ON countries.country_id = cities.countryId ORDER BY city_id"; // LEFT JOIN airlines ON countries.country_id = airlines.countryId
    private final String DELETE_BY_ID = "DELETE FROM cities WHERE city_id = ?";
    private final String UPDATE_CITY = "UPDATE cities SET city_name =  ?, countryId = ? WHERE city_id = ?";
    private final String DELETE_ALL = "DELETE FROM cities";
    private final Logger LOGGER = LogManager.getLogger(CityDAO.class);

    public CityDAO() throws SQLException {
    }

    @Override
    public City getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_CITY_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country(result.getString("country_name"), result.getInt("countryId"));
            City city = new City(result.getInt("city_id"), result.getString("city_name"), country);

            return city;
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
    public ArrayList<City> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(GET_ALL_CITIES);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<City> cities = new ArrayList<>();

            while (result.next()) {
                Country country = new Country(result.getString("country_name"), result.getInt("countryId"));
                City city = new City(result.getInt("city_id"), result.getString("city_name"), country);

                cities.add(city);
            }

            return cities;
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
    public void insertRow(City object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(INSERT_CITY);
            preparedStatement.setString(1, object.getCity_name());
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
    public void updateRow(int id, City object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_CITY);
            preparedStatement.setString(1, object.getCity_name());
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
}
