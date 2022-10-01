package jdbc.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.text.ParseException;

public class ProxyRunner {

    private static final Logger LOGGER = LogManager.getLogger(ProxyRunner.class);

    public static void main(String[] args) throws SQLException, ParseException {

        ProxyFlight testProxy = new ProxyFlight(1);

        LOGGER.info(testProxy);
    }
}
