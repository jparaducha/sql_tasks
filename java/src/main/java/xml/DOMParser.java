package xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {
    private static final Logger LOGGER = LogManager.getLogger(DOMParser.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException {

        File xmlFile = new File("src\\main\\java\\xml\\airports.xml");

        Element parsedFile = parseElement(xmlFile);

        //LOGGER.info("Root element: " + parsedFile.getNodeName());
        //LOGGER.info("Root element: " + parsedFile.getFirstChild());
        //LOGGER.info("getNodeName(): " + parsedFile.getElementsByTagName("flight_id").item(0).getNodeName());
        //LOGGER.info("getNodeValue(): " + parsedFile.getElementsByTagName("flight_id").item(0).getNodeValue());

        LOGGER.info("tagname" + parsedFile.getTagName());
        LOGGER.info("tagnames ? " + parsedFile.getFirstChild());

        NodeList nodeList = parsedFile.getElementsByTagName("airport");
       /* for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            System.out.println(" - " + node.getTextContent());
        }
*/
        NodeList childNodes = parsedFile.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                LOGGER.info("-------------------------------------");
                LOGGER.info("nodeName : " + childNode.getNodeName());
            } else {
                continue;
            }
            NodeList childNodes2 = childNode.getChildNodes();

            for (int j = 0; j < childNodes2.getLength(); j++) {
                Node childNode2 = childNodes2.item(j);

                if (childNode2.getNodeType() == Node.ELEMENT_NODE) {

                    LOGGER.info(childNode2.getNodeName() + " === " + childNode2.getTextContent());
                }
            }

            //LOGGER.info(childNode.getTextContent());
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
