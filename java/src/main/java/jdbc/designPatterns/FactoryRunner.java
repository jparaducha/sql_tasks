package jdbc.designPatterns;

import jdbc.model.Passenger;
import jdbc.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.text.ParseException;

public class FactoryRunner {
    private static final Logger LOGGER = LogManager.getLogger(FactoryRunner.class);

    public static void main(String[] args) throws SQLException, ParseException {

        IFactory factory = new SchemaFactory();

        Passenger testPassenger = factory.getPassenger();

        Plane testPlane = (Plane) factory.getInstance("PLANE");

        LOGGER.info(testPassenger);

        LOGGER.info(testPlane);

        ProxyFlight testProxy = new ProxyFlight(1);

        LOGGER.info(testProxy);
    }
}
