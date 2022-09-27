package jdbc.DAO;

import jdbc.model.Plane;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlaneDAO {
    Plane getPlaneById(int id) throws SQLException;

    ArrayList<Plane> getAllPlanes() throws SQLException;

    void insertPlane(Plane object) throws SQLException;

    void deletePlaneById(int id) throws SQLException;

    void updatePlane(@Param("id") int id, @Param("object") Plane object) throws SQLException;

    void deleteAllPlanes() throws SQLException;
}
