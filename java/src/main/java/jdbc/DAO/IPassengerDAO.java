package jdbc.DAO;

import jdbc.model.Passenger;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPassengerDAO {

    Passenger getPassengerById(int id) throws SQLException;

    ArrayList<Passenger> getAllPassengers() throws SQLException;

    void insertPassenger(Passenger object) throws SQLException;

    void deletePassengerById(int id) throws SQLException;

    void updatePassenger(@Param("id") int id, @Param("object") Passenger object) throws SQLException;

    void deleteAllPassengers() throws SQLException;
}
