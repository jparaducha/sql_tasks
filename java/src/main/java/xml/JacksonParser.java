package xml;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdbc.City;
import jdbc.Country;
import jdbc.DAO.mysql.FlightDAO;
import jdbc.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class JacksonParser {

    private static final Logger LOGGER = LogManager.getLogger(JacksonParser.class);

    public static void main(String[] args) throws IOException, SQLException {

        ObjectMapper objectMapper = new ObjectMapper();

        Country argentina = new Country();
        argentina.setCountryName("Argentina");
        argentina.setCountryId(1986);

        City city = new City();
        city.setCityName("P.R. Sáenz Peña");
        city.setCityId(1915);
        city.setCountry(argentina);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("java\\src\\main\\resources\\json\\cityTest.json"), city);

        File cityJson = new File("java\\src\\main\\resources\\json\\city.json");
        File flightJson = new File("java\\src\\main\\resources\\json\\flight.json");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //

        Flight flight4 = new FlightDAO().getById(4);

        City city1 = objectMapper.readValue(cityJson, City.class);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("java\\src\\main\\resources\\json\\flightTest.json"), flight4);

        Flight flight = objectMapper.readValue(flightJson, Flight.class);

        LOGGER.info(city1);
        LOGGER.info(flight);
    }
}
