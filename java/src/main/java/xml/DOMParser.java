package xml;

import jdbc.Airport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class DOMParser {
    private static final Logger LOGGER = LogManager.getLogger(DOMParser.class);

    public static void main(String[] args) {

        File xmlFile = new File("java\\src\\main\\resources\\airports.xml");

        Element parsedFile = parseElement(xmlFile);

        NodeList childNodes = parsedFile.getChildNodes();
        ArrayList<Airport> airports = new ArrayList<>();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Airport airport = new Airport();
            Node airportNode = childNodes.item(i);

            if (airportNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            NodeList airportElementsList = airportNode.getChildNodes();

            for (int j = 0; j < airportElementsList.getLength(); j++) {
                Node airportElementNode = airportElementsList.item(j);

                if (airportElementNode.getNodeType() == Node.ELEMENT_NODE) {

                    switch (airportElementNode.getNodeName()) {
                        case "airportId":
                            airport.setAirportId(Integer.parseInt(airportElementNode.getTextContent()));
                            break;
                        case "airportName":
                            airport.setAirportName(airportElementNode.getTextContent());
                            break;
                        case "iataCode":
                            airport.setIataCode(airportElementNode.getTextContent());
                        default:
                            break;
                    }
                }
            }
            airports.add(airport);
        }

        for (Airport airport : airports) {
            LOGGER.info(airport);
        }
    }

    public static Element parseElement(File xml) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xml);
            return doc.getDocumentElement();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
