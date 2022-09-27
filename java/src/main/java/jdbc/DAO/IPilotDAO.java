package jdbc.DAO;

import jdbc.model.Pilot;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPilotDAO {

    Pilot getPilotById(int id) throws SQLException;

    ArrayList<Pilot> getAllPilots() throws SQLException;

    void insertPilot(Pilot object) throws SQLException;

    void deletePilotById(int id) throws SQLException;

    void updatePilot(@Param("id") int id, @Param("object") Pilot object) throws SQLException;

    void deleteAllPilots() throws SQLException;
}
