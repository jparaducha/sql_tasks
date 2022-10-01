package jdbc.factory;

import jdbc.model.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoryRunner {
    private static final Logger LOGGER = LogManager.getLogger(FactoryRunner.class);

    public static void main(String[] args) {

        IFactory factory = new SchemaFactory();

        Passenger testPassenger = factory.getPassenger();

        LOGGER.info(testPassenger);
    }
}
