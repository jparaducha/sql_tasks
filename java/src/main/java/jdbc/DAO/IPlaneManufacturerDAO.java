package jdbc.DAO;

import jdbc.model.PlaneManufacturer;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlaneManufacturerDAO {

    PlaneManufacturer getManufacturerById(int id) throws SQLException;

    ArrayList<PlaneManufacturer> getAllManufacturers() throws SQLException;

    void insertManufacturer(PlaneManufacturer object) throws SQLException;

    void deleteManufacturerById(int id) throws SQLException;

    void updateManufacturer(@Param("id") int id, @Param("object") PlaneManufacturer object) throws SQLException;

    void deleteAllManufacturers() throws SQLException;
}
