package jdbc.designPatterns;

import jdbc.DAO.mySQLservice.IBaseService;
import jdbc.model.Airline;
import jdbc.model.Country;
import jdbc.model.Passenger;
import jdbc.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;

public class FactoryRunner {
    private static final Logger LOGGER = LogManager.getLogger(FactoryRunner.class);

    public static void main(String[] args) throws SQLException, ParseException, IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        IFactory factory = new SchemaFactory("dao");

        Airline testCreate = (Airline) SchemaFactory.createObject("jdbc.model.Airline");
        IBaseService<Country> testCreate0 = SchemaFactory.create("jdbc.DAO.mySQLservice.PilotService");

        LOGGER.info(testCreate);
        LOGGER.info(testCreate0);

        Country asd = factory.getCountry(11);

        LOGGER.info(asd);

        Passenger testPassenger = factory.getPassenger();

        Plane testPlane = (Plane) factory.getInstance("PLANE");

        LOGGER.info(testPassenger);

        LOGGER.info(testPlane);

        ProxyFlight testProxy = new ProxyFlight(1);

        LOGGER.info(testProxy);
    }
}
