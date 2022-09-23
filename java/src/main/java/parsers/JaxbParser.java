package parsers;

import jdbc.Airport;
import jdbc.City;
import jdbc.Country;
import jdbc.DAO.mysql.FlightDAO;
import jdbc.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class JaxbParser {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    private static String basePath = "java\\src\\main\\resources\\xml\\";

    public static void main(String[] args) throws JAXBException, IOException {
        try {

            objectToXML();

            String newXmlPath = basePath + "airportTest.xml";

            Airport unmarshalledAirport = xmlToAirport(newXmlPath);

            LOGGER.info(unmarshalledAirport);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void objectToXML() throws JAXBException, IOException, SQLException {

        Airport airport = new Airport();
        airport.setAirportName("Airport Test Name");
        airport.setAirportId(17);
        airport.setIataCode("ATN");

        Country argentina = new Country();
        argentina.setCountryName("Argentina");
        argentina.setCountryId(1986);

        City city = new City();
        city.setCityName("P.R. Sáenz Peña");
        city.setCityId(1915);
        city.setCountry(argentina);

        Flight flight4 = new FlightDAO().getById(5);

        JAXBContext flightContext = JAXBContext.newInstance(Flight.class);
        Marshaller flightContextMarshaller = flightContext.createMarshaller();
        flightContextMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        flightContextMarshaller.marshal(flight4, new File(basePath + "flightTest.xml"));

        LOGGER.info(flight4);

        JAXBContext cityContext = JAXBContext.newInstance(City.class);
        Marshaller cityMar = cityContext.createMarshaller();
        cityMar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        cityMar.marshal(city, new File(basePath + "cityTest.xml"));

        JAXBContext context = JAXBContext.newInstance(Airport.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(airport, new File(basePath + "airportTest.xml"));
    }

    public static Airport xmlToAirport(String xmlPath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Airport.class);
        return (Airport) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    }
}

