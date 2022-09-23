package parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidateXMLSchema {
    private static final Logger LOGGER = LogManager.getLogger(ValidateXMLSchema.class);

    public static void main(String[] args) {

        LOGGER.info("flight.xml validates against flight.xsd?  " + XMLValidator("java\\src\\main\\resources\\xml\\flight.xsd", "java\\src\\main\\resources\\xml\\flight.xml"));
        LOGGER.info("airports.xml validates against airport.xsd? " + XMLValidator("java\\src\\main\\resources\\xml\\airport.xsd", "java\\src\\main\\resources\\xml\\airports.xml"));
        LOGGER.info("airport2.xml validates against airport.xsd? " + XMLValidator("java\\src\\main\\resources\\xml\\airport.xsd", "java\\src\\main\\resources\\xml\\airport2.xml"));
        LOGGER.info("planes.xml validates against planes.xsd? " + XMLValidator("java\\src\\main\\resources\\xml\\planes.xsd", "java\\src\\main\\resources\\xml\\planes.xml"));
    }

    public static boolean XMLValidator(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (Exception e) {
            LOGGER.error("Exception: " + e.getMessage());
            return false;
        } catch (Error e) {
            e.printStackTrace();
            LOGGER.error("Error: " + e.getMessage());
        }

        return true;
    }
}
