package jdbc.DAO;

import jdbc.model.Airline;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAirlineDAO {

    Airline getAirlineById(int id) throws SQLException;

    ArrayList<Airline> getAllAirlines() throws SQLException;

    void insertAirline(Airline object) throws SQLException;

    void deleteAirlineById(int id) throws SQLException;

    void updateAirline(@Param("id") int id, @Param("object") Airline object) throws SQLException;

    void deleteAllAirlines() throws SQLException;
}
