package jdbc.DAO;

import jdbc.Plane;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlaneDAO {
    Plane getPlaneById(long id) throws SQLException;

    ArrayList<Plane> getAllPlanes() throws SQLException;

    void insertPlane(int year, int model) throws SQLException;

    void updatePlane(Plane plane) throws SQLException;

    void deletePlane(long planeId) throws SQLException;
}
