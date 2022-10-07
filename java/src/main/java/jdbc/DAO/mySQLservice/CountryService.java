package jdbc.DAO.mySQLservice;

import jdbc.DAO.mysql.AirlineDAO;
import jdbc.DAO.mysql.CityDAO;
import jdbc.DAO.mysql.CountryDAO;
import jdbc.model.Airline;
import jdbc.model.City;
import jdbc.model.Country;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryService implements IBaseService<Country> {

    private CountryDAO countryDAO = new CountryDAO();
    private CityDAO cityDAO = new CityDAO();
    private AirlineDAO airlineDAO = new AirlineDAO();

    public CountryService() throws SQLException {
    }

    @Override
    public Country getById(int id) throws SQLException {
        Country country = countryDAO.getById(id);

        ArrayList<Airline> airlines = airlineDAO.getByCountryId(id);
        ArrayList<City> cities = cityDAO.getByCountryId(id);

        country.setAirlines(airlines);
        country.setCities(cities);

        return country;
    }

    @Override
    public void insert(Country country) throws SQLException {
        countryDAO.insertRow(country);
    }

    @Override
    public void delete(int id) throws SQLException {
        countryDAO.deleteById(id);
    }

    @Override
    public void update(Country country) throws SQLException {
        countryDAO.updateRow(country.getCountryId(), country);
    }

    @Override
    public List<?> getAll() throws SQLException {
        return countryDAO.getAll();
    }
}
