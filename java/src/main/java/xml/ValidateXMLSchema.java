package xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidateXMLSchema {
    static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    private static final Logger LOGGER = LogManager.getLogger(ValidateXMLSchema.class);

    public static void main(String[] args) {

        /*
        LOGGER.info("flight.xml validates against flight.xsd? " + XMLValidator("src\\main\\java\\xml\\flight.xsd", "src\\main\\java\\xml\\flight.xml"));
        LOGGER.info("airports.xml validates against airport.xsd? " + XMLValidator("src\\main\\java\\xml\\airport.xsd", "src\\main\\java\\xml\\airports.xml"));
        LOGGER.info("airport2.xml validates against airport.xsd? " + XMLValidator("src\\main\\java\\xml\\airport.xsd", "src\\main\\java\\xml\\airport2.xml"));
        */
        LOGGER.info("validating flight: " + XMLValidator("src\\main\\java\\xml\\flight.xsd", "src\\main\\java\\xml\\flight.xml"));

        LOGGER.info("validating airport2: " + XMLValidator("src\\main\\java\\xml\\airport.xsd", "src\\main\\java\\xml\\airport2.xml"));
    }

    public static boolean XMLValidator(String xsdPath, String xmlPath) {
        DocumentBuilderFactory documentBuilderFactoryfactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryfactory.setNamespaceAware(true);
        documentBuilderFactoryfactory.setValidating(true);

        documentBuilderFactoryfactory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

        // Set the schema file
        documentBuilderFactoryfactory.setAttribute(JAXP_SCHEMA_SOURCE, new File(xsdPath));

        try {
            DocumentBuilder parser = documentBuilderFactoryfactory.newDocumentBuilder();

            // Parses the file. if an error is found it will be printed  ?????
            Document document = parser.parse(xmlPath);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
        } catch (Exception e) {
            LOGGER.error("Exception: " + e.getMessage());
            //e.printStackTrace();
            return false;
        } catch (Error e) {
            e.printStackTrace();
            LOGGER.error("Error: " + e.getMessage());
        }

        return true;
    }
}
