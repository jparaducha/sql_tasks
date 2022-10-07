package jdbc.designPatterns;

import jdbc.DAO.mySQLservice.IBaseService;
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

        IBaseService<Country> testCreate = SchemaFactory.create("jdbc.DAO.mySQLservice.CountryService");

        LOGGER.info(testCreate);

        Passenger testPassenger = factory.getPassenger();

        Plane testPlane = (Plane) factory.getInstance("PLANE");

        LOGGER.info(testPassenger);

        LOGGER.info(testPlane);

        ProxyFlight testProxy = new ProxyFlight(1);

        LOGGER.info(testProxy);
    }
}
