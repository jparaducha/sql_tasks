package jdbc.DAO;

import jdbc.model.City;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICityDAO {

    City getCityById(int id) throws SQLException;

    ArrayList<City> getAllCities() throws SQLException;

    void insertCity(City object) throws SQLException;

    void deleteCityById(int id) throws SQLException;

    void updateCity(@Param("id") int id, @Param("object") City object) throws SQLException;

    void deleteAllCities() throws SQLException;
}
