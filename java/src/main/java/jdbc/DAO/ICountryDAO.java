package jdbc.DAO;

import jdbc.model.Country;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICountryDAO {

    Country getCountryById(int id) throws SQLException;

    ArrayList<Country> getAllCountries() throws SQLException;

    void insertCountry(Country object) throws SQLException;

    void deleteCountryById(int id) throws SQLException;

    void updateCountry(@Param("id") int id, @Param("object") Country object) throws SQLException;

    void deleteAllCountries() throws SQLException;
}
