package jdbc.DAO;

import jdbc.model.Airport;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAirportDAO {

    Airport getAirportById(int id) throws SQLException;

    ArrayList<Airport> getAllAirports() throws SQLException;

    void insertAirport(Airport object) throws SQLException;

    void deleteAirportById(int id) throws SQLException;

    void updateAirport(@Param("id") int id, @Param("object") Airport object) throws SQLException;

    void deleteAllAirports() throws SQLException;
}
