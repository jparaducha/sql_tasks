package jdbc.DAO;

import jdbc.model.Flight;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IFlightDAO {

    Flight getFlightById(int id) throws SQLException;

    ArrayList<Flight> getAllFlights() throws SQLException;

    void insertFlight(Flight object) throws SQLException;

    void deleteFlightById(int id) throws SQLException;

    void updateFlight(@Param("id") int id, @Param("object") Flight object) throws SQLException;

    void deleteAllFlights() throws SQLException;
}
