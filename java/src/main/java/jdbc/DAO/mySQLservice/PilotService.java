package jdbc.DAO.mySQLservice;

import jdbc.DAO.mysql.PilotDAO;
import jdbc.DAO.mysql.PilotLicenseDAO;
import jdbc.model.Pilot;
import jdbc.model.PilotLicense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PilotService implements IBaseService<Pilot> {

    private static final Logger LOGGER = LogManager.getLogger(PilotService.class);

    private PilotDAO pilotDAO = new PilotDAO();
    private PilotLicenseDAO pilotLicenseDAO = new PilotLicenseDAO();

    public PilotService() throws SQLException {
    }

    @Override
    public Pilot getById(int id) throws SQLException {
        try {
            Pilot pilot = pilotDAO.getById(id);

            PilotLicense pilotLicense = pilotLicenseDAO.getByPilotId(id);

            pilot.setLicense(pilotLicense);

            return pilot;
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }

    @Override
    public void insert(Pilot pilot) throws SQLException {
        try {
            pilotDAO.insertRow(pilot);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            pilotDAO.deleteById(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Pilot pilot) throws SQLException {
        try {
            pilotDAO.updateRow(pilot.getPilotId(), pilot);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Pilot> getAll() throws SQLException {
        try {
            return pilotDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }
}
