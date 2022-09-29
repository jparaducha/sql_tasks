package myBatis;

import jdbc.DAO.IFlightDAO;
import jdbc.DAO.IPlaneDAO;
import jdbc.DAO.IPlaneManufacturerDAO;
import jdbc.DAO.IPlaneModelDAO;
import jdbc.model.Flight;
import jdbc.model.Plane;
import jdbc.model.PlaneManufacturer;
import jdbc.model.PlaneModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainMyBatis {
    private static final Logger LOGGER = LogManager.getLogger(MainMyBatis.class);

    public static void main(String[] args) throws IOException, SQLException {
        try {

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            IPlaneDAO planeMapper = session.getMapper(IPlaneDAO.class);
            Plane plane = planeMapper.getPlaneById(1);

            LOGGER.info("plane: " + plane);

            Plane testPlane = new Plane();
            testPlane.setModelId(3);
            testPlane.setYear((int) (Math.random() * (100) + 4000));

            // planeMapper.insertPlane(testPlane);

            testPlane.setYear(2025);

            planeMapper.updatePlane(63, testPlane);

            ArrayList<Plane> planes = planeMapper.getAllPlanes();

            for (Plane planeT : planes) {
                LOGGER.info(planeT);
            }

            IPlaneModelDAO planeModelMapper = session.getMapper(IPlaneModelDAO.class);
            PlaneModel testModel = planeModelMapper.getPlaneModelById(2);

            LOGGER.info("plane model: " + testModel);

            IPlaneManufacturerDAO manufacturerMapper = session.getMapper(IPlaneManufacturerDAO.class);

            PlaneManufacturer testManufacturer = manufacturerMapper.getManufacturerById(2);

            LOGGER.info(testManufacturer);
/*
            IPilotDAO pilotMapper = session.getMapper(IPilotDAO.class);
            Pilot testPilot = pilotMapper.getPilotById(1);
            LOGGER.info(testPilot);
            Pilot newPilot = new Pilot(77, "Test Pilot", 77, new PilotLicenseDAO().getById(1));

            pilotMapper.insertPilot(newPilot);
*/
            IFlightDAO flightMapper = session.getMapper(IFlightDAO.class);
            Flight testFlight = flightMapper.getFlightById(2);
            LOGGER.info(testFlight);

            ArrayList<Flight> testFlights = flightMapper.getAllFlights();

            for (Flight flight : testFlights) {
                LOGGER.info(flight);
            }

            session.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }
}
