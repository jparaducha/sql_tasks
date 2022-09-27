package jdbc.DAO;

import jdbc.model.PilotLicense;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPilotLicenseDAO {

    PilotLicense getLicenseById(int id) throws SQLException;

    ArrayList<PilotLicense> getAllLicenses() throws SQLException;

    void insertLicense(PilotLicense object) throws SQLException;

    void deleteLicenseById(int id) throws SQLException;

    void updateLicense(@Param("id") int id, @Param("object") PilotLicense object) throws SQLException;

    void deleteAllLicenses() throws SQLException;
}
