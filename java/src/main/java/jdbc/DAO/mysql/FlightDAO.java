package jdbc.DAO.mysql;

import jdbc.*;
import jdbc.DAO.ConnectionPool;
import jdbc.DAO.IBaseDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightDAO implements IBaseDAO<Flight> {

    private final String INSERT_FLIGHT = "INSERT INTO flights(airlineId,pilotId,planeId,price, departure_time, arrival_time, flight_duration) " + "VALUES(?,?,?,?,?,?,?)";
    private final String GET_FLIGHT_BY_ID = "SELECT *, a2.airport_name AS a2_name, a1.airport_name AS a1_name, a1.airport_id AS a1Id, a2.airport_id AS a2Id, a1.IATA_code AS a1IATA, a2.IATA_code AS a2IATA, c1.city_name AS city1, c2.city_name AS city2, con1.country_name AS con1, con2.country_name AS con2, con1.country_id AS con1id, con2.country_id AS con2id, con3.country_name AS con3, con3.country_id AS con3id, c1.city_id AS city1id, c2.city_id AS city2id FROM flights JOIN airlines ON airlines.airline_id = flights.airlineId JOIN countries con3 ON airlines.countryId = con3.country_id  JOIN planes ON planes.plane_id = flights.planeId JOIN plane_models ON planes.modelId = plane_models.model_id JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id JOIN pilots ON pilots.id_pilot = flights.pilotId JOIN pilot_licenses ON pilots.id_pilot = pilot_licenses.pilotId LEFT JOIN airport_flights af1 ON flights.flight_id = af1.flightId LEFT JOIN airports a1 ON af1.departure_airportId = a1.airport_id LEFT JOIN airport_flights af2 ON flights.flight_id = af2.flightId LEFT JOIN airports a2 ON af2.arrival_airportId = a2.airport_id INNER JOIN cities c1 ON c1.city_id = a1.cityId INNER JOIN cities c2 ON c2.city_id = a2.cityId INNER JOIN countries con1 ON con1.country_id = c1.countryId INNER JOIN countries con2 ON con2.country_id = c2.countryId JOIN tickets ON flights.flight_id = tickets.flightId JOIN passengers ON passengers.passenger_id = tickets.passengerId WHERE flight_id = ?";
    private final String GET_ALL_FLIGHTS = "SELECT *, a2.airport_name AS a2_name, a1.airport_name AS a1_name, a1.airport_id AS a1Id, a2.airport_id AS a2Id, a1.IATA_code AS a1IATA, a2.IATA_code AS a2IATA, c1.city_name AS city1, c2.city_name AS city2, con1.country_name AS con1, con2.country_name AS con2, con1.country_id AS con1id, con2.country_id AS con2id, con3.country_name AS con3, con3.country_id AS con3id, c1.city_id AS city1id, c2.city_id AS city2id FROM flights JOIN airlines ON airlines.airline_id = flights.airlineId JOIN countries con3 ON airlines.countryId = con3.country_id JOIN planes ON planes.plane_id = flights.planeId JOIN plane_models ON planes.modelId = plane_models.model_id JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id JOIN pilots ON pilots.id_pilot = flights.pilotId JOIN pilot_licenses ON pilots.id_pilot = pilot_licenses.pilotId LEFT JOIN airport_flights af1 ON flights.flight_id = af1.flightId LEFT JOIN airports a1 ON af1.departure_airportId = a1.airport_id LEFT JOIN airport_flights af2 ON flights.flight_id = af2.flightId LEFT JOIN airports a2 ON af2.arrival_airportId = a2.airport_id INNER JOIN cities c1 ON c1.city_id = a1.cityId INNER JOIN cities c2 ON c2.city_id = a2.cityId INNER JOIN countries con1 ON con1.country_id = c1.countryId INNER JOIN countries con2 ON con2.country_id = c2.countryId JOIN tickets ON flights.flight_id = tickets.flightId JOIN passengers ON passengers.passenger_id = tickets.passengerId ORDER BY flight_id";
    private final String DELETE_BY_ID = "DELETE FROM flights WHERE flight_id = ?";
    private final String UPDATE_FLIGHT = "UPDATE flights SET airlineId = ?, pilotId = ?, planeId = ?, price = ?, departure_time = ? , arrival_time = ?, flight_duration = ? WHERE flight_id = ?";
    private final String DELETE_ALL = "DELETE FROM flights";
    private final Logger LOGGER = LogManager.getLogger(FlightDAO.class);

    public FlightDAO() throws SQLException {
    }

    @Override
    public Flight getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Flight flight = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_FLIGHT_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Passenger> passengers = new ArrayList<>();

            result.next();

            PilotLicense license = new PilotLicense(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));
            Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

            PlaneManufacturer manufacturer = new PlaneManufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));
            Plane plane = new Plane(result.getInt("plane_id"), result.getInt("year"), result.getString(result.findColumn("model_name")), manufacturer);

            Country country1 = new Country(result.getString("con1"), result.getInt("con1id"));
            City city1 = new City(result.getInt("city1id"), result.getString("city1"), country1);
            Airport departure_airport = new Airport(result.getInt("a1id"), result.getString("a1_name"), result.getString("a1IATA"), city1);

            Country country2 = new Country(result.getString("con2"), result.getInt("con2id"));
            City city2 = new City(result.getInt("city2id"), result.getString("city2"), country2);
            Airport arrival_airport = new Airport(result.getInt("a2id"), result.getString("a2_name"), result.getString("a2IATA"), city2);

            Country country3 = new Country(result.getString("con3"), result.getInt("con3id"));
            Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country3);

            passengers.add(new Passenger(result.getInt("passenger_id"), result.getString("passenger_name")));

            while (result.next()) {
                passengers.add(new Passenger(result.getInt("passenger_id"), result.getString("passenger_name")));
            }

            result.previous();
            flight = new Flight(result.getInt("flight_id"), result.getString("flight_duration"), result.getDouble("price"), result.getString("departure_time"), result.getString("arrival_time"), arrival_airport, departure_airport, pilot, plane, airline, passengers);

            return flight;
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
    public ArrayList<Flight> getAll() throws SQLException {

        PreparedStatement preparedStatement = null;

        ArrayList<Flight> flights = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(GET_ALL_FLIGHTS, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet result = preparedStatement.executeQuery();

            flights = new ArrayList<>();

            while (result.next()) {

                ArrayList<Passenger> passengers = new ArrayList<>();

                int currFlightId = result.getInt("flight_id");

                PilotLicense license = new PilotLicense(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));
                Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

                PlaneManufacturer manufacturer = new PlaneManufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));
                Plane plane = new Plane(result.getInt("plane_id"), result.getInt("year"), result.getString(result.findColumn("model_name")), manufacturer);

                Country country1 = new Country(result.getString("con1"), result.getInt("con1id"));
                City city1 = new City(result.getInt("city1id"), result.getString("city1"), country1);
                Airport departure_airport = new Airport(result.getInt("a1id"), result.getString("a1_name"), result.getString("a1IATA"), city1);

                Country country2 = new Country(result.getString("con2"), result.getInt("con2id"));
                City city2 = new City(result.getInt("city2id"), result.getString("city2"), country2);
                Airport arrival_airport = new Airport(result.getInt("a2id"), result.getString("a2_name"), result.getString("a2IATA"), city2);

                Country country3 = new Country(result.getString("con3"), result.getInt("con3id"));
                Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country3);

                passengers.add(new Passenger(result.getInt("passenger_id"), result.getString("passenger_name")));

                while (result.getInt("flight_id") == currFlightId && result.next()) {
                    passengers.add(new Passenger(result.getInt("passenger_id"), result.getString("passenger_name")));
                }

                result.previous();
                Flight flight = new Flight(result.getInt("flight_id"), result.getString("flight_duration"), result.getDouble("price"), result.getString("departure_time"), result.getString("arrival_time"), arrival_airport, departure_airport, pilot, plane, airline, passengers);

                flights.add(flight);
            }

            return flights;
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
    public void insertRow(Flight object) throws SQLException {
        PreparedStatement preparedStatement = null;

        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(INSERT_FLIGHT);
            preparedStatement.setInt(1, object.getAirline().getAirlineId());
            preparedStatement.setInt(2, object.getPilot().getPilotId());
            preparedStatement.setInt(3, object.getPlane().getPlaneId());
            preparedStatement.setDouble(4, object.getPrice());
            preparedStatement.setString(5, object.getDepartureTime());
            preparedStatement.setString(6, object.getArrivalTime());
            preparedStatement.setString(7, object.getFlightDuration());

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

        Connection connection = null;
        PreparedStatement preparedStatement = null;
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
    public void updateRow(int id, Flight object) throws SQLException {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FLIGHT);
            preparedStatement.setInt(1, object.getAirline().getAirlineId());
            preparedStatement.setInt(2, object.getPilot().getPilotId());
            preparedStatement.setInt(3, object.getPlane().getPlaneId());
            preparedStatement.setDouble(4, object.getPrice());
            preparedStatement.setString(5, object.getDepartureTime());
            preparedStatement.setString(6, object.getArrivalTime());
            preparedStatement.setString(7, object.getFlightDuration());
            preparedStatement.setInt(8, id);

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
