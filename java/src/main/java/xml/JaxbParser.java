package xml;

import jdbc.Airport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JaxbParser {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    public static void main(String[] args) throws JAXBException, IOException {
        try {
            objectToXML();

            String newXmlPath = "java\\src\\main\\resources\\airportTest.xml";

            Airport unmarshalledAirport = xmlToAirport(newXmlPath);

            LOGGER.info(unmarshalledAirport);

        /*
        //2022-11-04 02:00:00'
        String pattern = "yyyy-mm-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("sp", "AR"));
        String date = simpleDateFormat.format(new Date());
        LOGGER.info(date);

         */
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void objectToXML() throws JAXBException, IOException {

        Airport airport = new Airport();
        airport.setAirportName("Airport Test Name");
        airport.setAirportId(17);
        airport.setIataCode("ATN");

        JAXBContext context = JAXBContext.newInstance(Airport.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(airport, new File("java\\src\\main\\resources\\airportTest.xml"));
    }

    public static Airport xmlToAirport(String xmlPath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Airport.class);
        return (Airport) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    }
}

