package jdbc.DAO.mySQLservice;

import jdbc.DAO.mysql.PlaneDAO;
import jdbc.DAO.mysql.PlaneModelDAO;
import jdbc.model.Plane;
import jdbc.model.PlaneModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PlaneService implements IBaseService<Plane> {

    private static final Logger LOGGER = LogManager.getLogger(PlaneService.class);

    private PlaneDAO planeDAO = new PlaneDAO();
    private PlaneModelDAO planeModelDAO = new PlaneModelDAO();

    public PlaneService() throws SQLException {
    }

    @Override
    public Plane getById(int id) throws SQLException {
        try {
            Plane plane = planeDAO.getById(id);

            PlaneModel planeModel = planeModelDAO.getByPlaneId(id);

            plane.setModelId(planeModel.getModelId());

            return plane;
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }

    @Override
    public void insert(Plane plane) throws SQLException {
        try {
            planeDAO.insertRow(plane);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            planeDAO.deleteById(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Plane plane) throws SQLException {
        try {
            planeDAO.updateRow(plane.getPlaneId(), plane);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Plane> getAll() throws SQLException {
        try {
            return planeDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }
}
