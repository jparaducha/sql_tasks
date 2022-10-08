package jdbc.DAO.mySQLservice;

import jdbc.DAO.mysql.AirlineDAO;
import jdbc.DAO.mysql.CityDAO;
import jdbc.DAO.mysql.CountryDAO;
import jdbc.model.Airline;
import jdbc.model.City;
import jdbc.model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryService implements IBaseService<Country> {
    private static final Logger LOGGER = LogManager.getLogger(CountryService.class);

    private CountryDAO countryDAO = new CountryDAO();
    private CityDAO cityDAO = new CityDAO();
    private AirlineDAO airlineDAO = new AirlineDAO();

    public CountryService() throws SQLException {
    }

    @Override
    public Country getById(int id) throws SQLException {
        try {
            Country country = countryDAO.getById(id);

            ArrayList<Airline> airlines = airlineDAO.getByCountryId(id);
            ArrayList<City> cities = cityDAO.getByCountryId(id);

            country.setAirlines(airlines);
            country.setCities(cities);

            return country;
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }

    @Override
    public void insert(Country country) throws SQLException {
        try {
            countryDAO.insertRow(country);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            countryDAO.deleteById(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Country country) throws SQLException {
        try {
            countryDAO.updateRow(country.getCountryId(), country);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Country> getAll() throws SQLException {
        try {
            return countryDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }
}
